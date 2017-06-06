package garage
import garage.Parts._

object Garage extends App {
	
	var bookedIn: Array[Vehicle] = _
	var employeeList: Array[Employee] = _
	
	def newCar(make:String, model:String, engineSize:Int, colour:String, vin:String): Unit ={
		var vehicle:Car = new Car(make, model, engineSize, colour, vin)
		bookedIn :+ vehicle
	}
	def newBike(make:String, model:String, engineSize:Int, colour:String, vin:String): Unit ={
		var vehicle:Bike = new Bike(make, model, engineSize, colour, vin)
		bookedIn :+ vehicle
	}
	def removeVehicle(vehicle: Vehicle): Unit ={
		for(i <- 0 to bookedIn.length) {
			if(bookedIn(i) == vehicle) {
				var a = bookedIn.toBuffer
				a.remove(i)
				bookedIn = a.toArray
			}
		}
	}
	
	def newEmployee(name:String, age:Int, annualWage:Float, jobRole:String): Unit ={
		var newEmp:Employee = new Employee(name, age, annualWage, jobRole)
		employeeList :+ newEmp
	}
	
	def fixingVehicle(vehicle: Vehicle): Unit ={
	
	}
	
	def calculateBill(timeTaken:Float, labourCost:Float, vehicle:Vehicle, partCost:Float): Float ={
		return timeTaken*labourCost + partCost
	}
}
