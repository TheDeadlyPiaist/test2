package garage

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 06/06/2017.
	*/
class Bike (make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String="") extends Vehicle(make, model, engineSize, colour, vin) {
	
	partList = partList ++ Parts.getParts(false)
	
	if(make == "" && model == "") {
		var makeModel:ArrayBuffer[String] = carInfo.randomMM(false)
		setMake(makeModel(0))
		setModel(makeModel(1))
	}
	
	override def toString(): String = {
		"Bike: " + initString()
	}
}
