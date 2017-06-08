package garage

import garage.Parts.Parts

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 05/06/2017.
	*/
class Vehicle(make:String, model:String, engineSize:Int=0, colour:String="", vin:String="") {
	private var iMake = make
	private var iModel = model
	private var iEngineSize = engineSize
	private var iColour = colour
	private var iVin = vin
	var partList:ArrayBuffer[Parts] = ArrayBuffer()
	private var iWorkedOn:Employee = null
	
	def setMake(nMake:String) = iMake = nMake
	def getMake: String = iMake
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
	def checkVehicle(): ArrayBuffer[Parts] ={
		var returnArray:ArrayBuffer[Parts] = ArrayBuffer()
		for(i <- partList.indices) {
			if(partList(i).getState()) {
				var part:Parts = partList(i)
				returnArray = returnArray :+ part
			}
		}
		returnArray
	}
	def breakVehicle(): Unit ={
		for(i <- partList.indices) {
			val rand:Double = Math.random()
			if(rand < 0.1) {
				partList(i).setState(true)
			}
		}
	}
	def fixCar(): Unit ={
	
	}
	def getTotalTime(): Float ={
		var listCheck:ArrayBuffer[Parts] = new ArrayBuffer[Parts]()
		var totalTime:Float = 0
		listCheck = checkVehicle()
		for(i <- listCheck.indices) {
			totalTime += listCheck(i).getTimeToFix()
		}
		totalTime
	}
	
	def getWorkedOn = if(iWorkedOn != null) true else false
	def getWorkedOnBy = if(iWorkedOn != null) iWorkedOn else "Not being worked on"
	def beingWorkedOn(employee: Employee) = iWorkedOn = employee
}