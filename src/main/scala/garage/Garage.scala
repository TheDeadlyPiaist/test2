package garage
import scala.collection.mutable.ArrayBuffer

object Garage extends App {
	
	var bookedIn: ArrayBuffer[Vehicle] = ArrayBuffer()
	var employeeList: ArrayBuffer[Employee] = ArrayBuffer()
	
	var timeNeeded:Float = 0
	var timePerDayPerPerson:Float = 480
	var totalAvailableTime:Float = 0
	
	init()
	openGarage()
	
	def init(): Unit ={
		val jack:Employee = new Employee("Jack", 21, 21000, "Mechanic")
		val bob:Employee = new Employee("Bob", 31, 33000, "Mechanic")
		val jess:Employee = new Employee("Jessica", 24, 27000, "Mechanic")
		val sarah:Employee = new Employee("Sarah", 29, 27500, "Mechanic")
		employeeList += jack
		employeeList += bob
		employeeList += jess
		employeeList += sarah
		
	}
	def newCar(make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String=""): Unit ={
		val vehicle:Car = new Car(make, model, engineSize, colour, vin)
		vehicle.breakVehicle()
		bookedIn = bookedIn :+ vehicle
	}
	def newBike(make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String=""): Unit ={
		val vehicle:Bike = new Bike(make, model, engineSize, colour, vin)
		vehicle.breakVehicle()
		bookedIn = bookedIn :+ vehicle
	}
	def removeVehicle(vehicle: Vehicle): Unit ={
		for(i <- bookedIn.indices) {
			if(bookedIn(i) == vehicle) {
				bookedIn.remove(i)
			}
		}
	}
	
	def removeAllVehicles(): Unit = bookedIn = null
	
	def newEmployee(name:String, age:Int, annualWage:Float, jobRole:String): Unit ={
		var newEmp:Employee = new Employee(name, age, annualWage, jobRole)
		employeeList :+ newEmp
	}
	
	def fixingVehicle(vehicle: Vehicle): Unit ={
	
	}
	
	def calculateBill(timeTaken:Float, labourCost:Float, vehicle:Vehicle, partCost:Float): Float ={
		timeTaken*labourCost + partCost
	}
	
	def openGarage (): Unit ={
		var totalTime:Float = 0
		totalAvailableTime = timePerDayPerPerson*employeeList.length
		for(i <- 1 to 8) {
			newCar()
		}
		for(i <- 1 to 3) {
			newBike()
		}
		for(i <- bookedIn.indices) {
			totalTime += bookedIn(i).getTotalTime
		}
		timeNeeded = totalTime
		assignJobs()
		printJobs()
	}
	def assignJobs (): Unit ={
		bookedIn(0).beingWorkedOn(employeeList(0))
		for(i <- bookedIn.indices) {
			if(!bookedIn(i).getWorkedOn) {
				for(j <- employeeList.indices if !bookedIn(i).getWorkedOn) {
					if(employeeList(j).hasTime(bookedIn(i))) {
						employeeList(j).newJob(bookedIn(i))
						bookedIn(i).beingWorkedOn(employeeList(j))
					}
				}
			}
		}
	}
	def printJobs(): Unit = {
		for(i <- employeeList.indices if employeeList(i).getRole == "Mechanic") {
			println(employeeList(i).toString())
			for(j <- employeeList(i).getCurrentJobs.indices) {
				val printVeh = employeeList(i).getCurrentJobs(j).toString
				println(s"           $printVeh")
			}
		}
		println("")
		for(i <- bookedIn.indices) {
			if(!bookedIn(i).getWorkedOn) {
				println("Hasn't been done: "+bookedIn(i))
			}
		}
	}
}
