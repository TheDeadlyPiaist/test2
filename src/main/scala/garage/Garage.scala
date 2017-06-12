package garage
import scala.collection.mutable.ArrayBuffer

object Garage extends App {
	
	var bookedIn: ArrayBuffer[Vehicle] = ArrayBuffer()
	var employeeList: ArrayBuffer[Employee] = ArrayBuffer()
	var totalTake:Double = 0
	
	var timePerDayPerPerson:Float = 480
	
	init()
	openGarage()
	closeGarage()
	
	def init(): Unit ={
		val jack:Employee = new Employee("Jack", 21, 21000, "Mechanic", timePerDayPerPerson)
		val bob:Employee = new Employee("Bob", 31, 33000, "Mechanic", timePerDayPerPerson)
		val jess:Employee = new Employee("Jessica", 24, 27000, "Mechanic", timePerDayPerPerson)
		val sarah:Employee = new Employee("Sarah", 29, 27500, "Mechanic", timePerDayPerPerson)
		employeeList += jack
		employeeList += bob
		employeeList += jess
		employeeList += sarah
		
	}
	def newCar(make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String=""): Vehicle ={
		new Car(make, model, engineSize, colour, vin)
	}
	def newBike(make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String=""): Bike ={
		new Bike(make, model, engineSize, colour, vin)
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
	def calculateBill(timeTaken:Float, labourCost:Float, vehicle:Vehicle, partCost:Float): Float ={
		timeTaken*labourCost + partCost
	}
	def assignJobs (): Unit ={
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
	def fixVehicles():Unit ={
		employeeList.foreach(i => {
			println("==================================================================================")
			println("Employee: " + i.getName())
			println("Total energy: " + i.energyGet)
			println("Jobs: " + i.getCurrentJobs.length)
			println("")
			i.getCurrentJobs.foreach(j => {
				val perMinuteCost:Double = 0.6666666666666
				val labour:Double = j.getTotalTime*perMinuteCost.toDouble
				val partCost:Double = j.getTotalCost.toDouble
				val profit:Double = partCost*0.2
				val totCost:Double = labour + partCost + profit
				totalTake += totCost
				
				println("------------")
				var tn:Float = j.getTotalTime //Time needed
				var rt:Float = i.energyGet //Remaining time
				var tu:Float = j.fixVehicle(rt) //Time used
				i.energyUse(tu)
				println("Vehicle: " + j.toString)
				println(f"			Time Needed: $tn%3.0f minutes			Time used: $tu%3.0f minutes 			Energy remaining: " + (i.energyGet))
				println(f"Labour Cost: £$labour%5.2f		Parts Cost: £$partCost%5.2f		VAT(20%%): £$profit%5.2f")
				println(f"Total Cost to Customer: £$totCost%5.2f")
			})
			println("------------")
		})
		println("==================================================================================")
	}
	def breakVehicles():Unit ={
		bookedIn.foreach(a => if(a.checkVehicle().isEmpty){a.breakVehicle()})
	}
	def printJobs(): Unit = {
		for(i <- employeeList.indices if employeeList(i).getRole == "Mechanic") {
			for(j <- employeeList(i).getCurrentJobs.indices) {
				val printVeh = employeeList(i).getCurrentJobs(j).toString
				println(s"           $printVeh")
			}
		}
		println("")
		for(i <- bookedIn.indices) {
			if(!bookedIn(i).getWorkedOn) {
			}
		}
	}
	
	def openGarage (): Unit ={
		for(i <- 1 to 8) {
			bookedIn = bookedIn :+ newCar()
		}
		for(i <- 1 to 3) {
			bookedIn = bookedIn :+ newBike()
		}
		
		breakVehicles()
		
		bookedIn.foreach(i => {
			println("Vehicle: " + i.getMake + " " + i.getModel() + "-------Broken Parts: " + i.checkVehicle())
		})
		println("")
		println("")
		
		assignJobs()
		fixVehicles()
	}
	def closeGarage():Unit ={
		var vehFix:Int = 0
		var needFix:ArrayBuffer[Vehicle] = ArrayBuffer()
		
		bookedIn.foreach(i => {
			if(i.checkVehicle().isEmpty) {
				vehFix += 1
			} else {
				needFix = needFix :+ i
			}
		})
		println("================================                  ================================")
		println("================================ End of Day Print ================================")
		println("================================                  ================================")
		println("==================================================================================")
		println(f"==  Total income: £$totalTake%5.2f")
		println(s"==  Vehicles fixed: $vehFix")
		if(!needFix.isEmpty) {
			needFix.foreach(a => println(a.getMake + " " + a.getModel()))
		} else {
			print("== All vehicles fixed")
		}
	}
}
