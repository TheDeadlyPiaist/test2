package garage

import garage.Parts.Parts
import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 06/06/2017.
	*/
class Bike (make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String="") extends Vehicle(make, model, engineSize, colour, vin) {
	
	//private var iWorkedOn:Employee = null
	
	if(make == "" && model == "") {
		var makeModel:ArrayBuffer[String] = carInfo.randomMM(false)
		setMake(makeModel(0))
		setModel(makeModel(1))
	}
	
	setPartList(generatePartList(false))
	
	override def toString(): String = {
		"Bike: " + initString()
	}/*
	override def checkVehicle(): ArrayBuffer[Part] ={
		var returnArray:ArrayBuffer[Part] = ArrayBuffer()
		iPartList.foreach(i =>
			if(i.getState) {
				returnArray = returnArray :+ i
			}
		)
		returnArray
	}*/
	override def breakVehicle():Unit ={
		for(i <- 0 until 3) {
			var rand:Int = Math.round(Math.random()*(getPartList.length-1)).toInt
			getPartList(rand).setState(true)
		}
	}/*
	override def fixVehicle(timeGiven:Float):Float ={
		var iTimeGiven:Float = timeGiven
		for(i <- iPartList.indices) {
			if(iPartList(i).getState && iTimeGiven >= iPartList(i).getTimeToFix) {
				iPartList(i).setState(false)
				iTimeGiven = iTimeGiven - iPartList(i).getTimeToFix
			}
		}
		timeGiven - iTimeGiven
	}
	override def getTotalTime: Float ={
		var listCheck:ArrayBuffer[Parts] = new ArrayBuffer[Parts]()
		var totalTime:Float = 0
		listCheck = checkVehicle()
		for(i <- listCheck.indices) {
			totalTime += listCheck(i).getTimeToFix
		}
		totalTime
	}
	
	override def getWorkedOn:Boolean = if(iWorkedOn != null) true else false
	override def getWorkedOnBy:Any = if(iWorkedOn != null) iWorkedOn else "Not being worked on"
	override def beingWorkedOn(employee: Employee):Unit = iWorkedOn = employee*/
}
