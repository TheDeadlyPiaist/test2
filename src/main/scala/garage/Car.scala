package garage

/**
	* Created by duane on 06/06/2017.
	*/
class Car (make:String, model:String, engineSize:Int, colour:String, vin:String) extends Vehicle(make, model, engineSize, colour, vin) {
	
	override def toString(): String = {
		return "Car: " + initString()
	}

}
