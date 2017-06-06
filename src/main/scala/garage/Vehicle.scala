package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Vehicle(make:String, model:String, engineSize:Int, colour:String, vin:String) {
	private var _make = make
	private var _model = model
	private var _engineSize = engineSize
	private var _colour = colour
	private var _vin = vin
	
	def setMake(nMake:String): Unit ={
		_make = nMake
	}
	
	def getMake(): String = {
		return _make
	}
	
	def setModel(nModel:String): Unit ={
		_model = nModel
	}
	
	def getModel(): String = {
		return _model
	}
	
	def setEngine(nEngine:Int): Unit ={
		_engineSize = nEngine
	}
	
	def getEngine(): Int = {
		return _engineSize
	}
	
	def setColour(nColour:String): Unit = {
		_colour = nColour
	}
	
	def getColour(): String = {
		return _colour
	}
	
	def setVIN(nVin:String): Unit ={
		_vin = nVin
	}
	
	def getVIN(): String = {
		return _vin
	}
	
	def initString(): String = {
		return s"$_make, $_model, $_engineSize, $_colour, $_vin"
	}
}
