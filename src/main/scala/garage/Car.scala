package garage

import garage.Parts.Parts

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 06/06/2017.
	*/
class Car (make:String="", model:String="", engineSize:Int=0, colour:String="", vin:String="") extends Vehicle(make, model, engineSize, colour, vin) {
	
	
	//var iPartList:ArrayBuffer[Parts] = Parts.getParts()
	//private var iWorkedOn:Employee = null
	setPartList(Parts.getParts())
	
	if(make == "" && model == "") {
		var makeModel:ArrayBuffer[String] = carInfo.randomMM()
		setMake(makeModel(0))
		setModel(makeModel(1))
	}
	
	override def toString(): String = {
		"Car: " + initString()
	}/*
	override def checkVehicle(): ArrayBuffer[Parts] ={
		var returnArray:ArrayBuffer[Parts] = ArrayBuffer()
		iPartList.foreach(i =>
			if(i.getState) {
				returnArray = returnArray :+ i
			}
		)
		returnArray
	}
	override def breakVehicle():Unit ={
		for(i <- 0 until 3) {
			var rand:Int = Math.round(Math.random()*(iPartList.length-1)).toInt
			iPartList(rand).setState(true)
		}
	}
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
