package garage

import garage.Parts._

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 05/06/2017.
	*/
class Vehicle(make:String, model:String, engineSize:Int=0, colour:String="", vin:String="", car:Boolean=true) {
	private var iMake = make
	private var iModel = model
	private var iEngineSize = engineSize
	private var iColour = colour
	private var iVin = vin
	private var partList:ArrayBuffer[Parts] = ArrayBuffer()
	private var iWorkedOn:Employee = null
	
	def clearFaults():Unit ={
		for(i <- partList.indices) {
			partList(i).setState(false)
		}
	}
	def setPartList(array:ArrayBuffer[Parts]) = partList = array
	def getPartList:ArrayBuffer[Parts] = partList
	def setMake(nMake:String):Unit = iMake = nMake
	def getMake: String = iMake
	def setModel(nModel:String): Unit =	iModel = nModel
	def getModel(): String = {
		iModel
	}
	def setEngine(nEngine:Int): Unit ={
		iEngineSize = nEngine
	}
	def getEngine(): Int = {
		iEngineSize
	}
	def setColour(nColour:String): Unit = {
		iColour = nColour
	}
	def getColour(): String = {
		iColour
	}
	def setVIN(nVin:String): Unit ={
		iVin = nVin
	}
	def getVIN(): String = {
		iVin
	}
	def initString(): String = {
		s"$iMake, $iModel"
	}
	def checkVehicle(): ArrayBuffer[Parts] ={
		var returnArray:ArrayBuffer[Parts] = ArrayBuffer()
		getPartList.foreach(i =>
			if(i.getState) {
				var part:Parts = i
				returnArray = returnArray :+ part
			}
		)
		returnArray
	}
	def breakVehicle():Unit ={}
	def fixVehicle(timeGiven:Float):Float ={
		var iTimeGiven:Float = timeGiven
		for(i <- partList.indices) {
			if(partList(i).getState && iTimeGiven >= partList(i).getTimeToFix) {
				partList(i).setState(false)
				iTimeGiven = iTimeGiven - partList(i).getTimeToFix
			}
		}
		timeGiven - iTimeGiven
	}
	def getTotalTime: Float ={
		var listCheck:ArrayBuffer[Parts] = new ArrayBuffer[Parts]()
		var totalTime:Float = 0
		listCheck = checkVehicle()
		for(i <- listCheck.indices) {
			totalTime += listCheck(i).getTimeToFix
		}
		totalTime
	}
	
	def getWorkedOn:Boolean = if(iWorkedOn != null) true else false
	def getWorkedOnBy:Any = if(iWorkedOn != null) iWorkedOn else "Not being worked on"
	def beingWorkedOn(employee: Employee):Unit = iWorkedOn = employee
	
}