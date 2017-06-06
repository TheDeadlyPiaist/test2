package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Vehicle(make:String, model:String, engineSize:Int, colour:String, vin:String) {
	private var iMake = make
	private var iModel = model
	private var iEngineSize = engineSize
	private var iColour = colour
	private var iVin = vin
	
	private var brokenParts:Array[String] = (null)
	
	def setMake(nMake:String): Unit ={
		iMake = nMake
	}
	
	def getMake(): String = {
		return iMake
	}
	
	def setModel(nModel:String): Unit ={
		iModel = nModel
	}
	
	def getModel(): String = {
		return iModel
	}
	
	def setEngine(nEngine:Int): Unit ={
		iEngineSize = nEngine
	}
	
	def getEngine(): Int = {
		return iEngineSize
	}
	
	def setColour(nColour:String): Unit = {
		iColour = nColour
	}
	
	def getColour(): String = {
		return iColour
	}
	
	def setVIN(nVin:String): Unit ={
		iVin = nVin
	}
	
	def getVIN(): String = {
		return iVin
	}
	
	def initString(): String = {
		return s"$iMake, $iModel, $iEngineSize, $iColour, $iVin"
	}
	
	def breakVehicle(): Unit ={}
	
	def fixCar(): Unit ={
		brokenParts = Array(null)
	}
}