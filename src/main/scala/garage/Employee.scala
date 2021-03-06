package garage

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 05/06/2017.
	*/
class Employee(name:String, age:Int, annualWage:Float, jobRole:String, availableTime:Float = 480) extends Person(name:String, age:Int) {
	
	private var iAnnualWage:Float = annualWage
	private var iJobRole = jobRole
	private var iAvailableTime = availableTime
	private var energy:Float = availableTime
	private var currentJobs:ArrayBuffer[Vehicle] = ArrayBuffer()
	
	def setWage(nWage:Int):Unit = iAnnualWage = nWage
	def getWage(asString:Boolean=true): Either[String, Float] = {
		if(asString) {
			Left(s"£$iAnnualWage")
		} else {
			Right(iAnnualWage)
		}
	}
	
	def setRole(nRole:String):Unit = iJobRole = nRole
	def getRole:String = iJobRole
	
	def resetTime():Unit = {iAvailableTime = 480}
	def useTime(amount:Float):Unit = {iAvailableTime = iAvailableTime - amount}
	def remainingTime:Float = iAvailableTime
	def hasTime(vehicle: Vehicle):Boolean = if(iAvailableTime >= vehicle.getTotalTime) true else false
	
	def energyUse(amount:Float):Unit = {energy=energy-amount}
	def energyGet = energy
	
	def getCurrentJobs:ArrayBuffer[Vehicle] = currentJobs
	def newJob(vehicle: Vehicle):Unit ={
		currentJobs = currentJobs :+ vehicle
		useTime(vehicle.getTotalTime)
	}
	def finishJob(vehicle: Vehicle): Unit ={
		for(i <- currentJobs.indices) {
			if(vehicle == currentJobs(i)) {
				currentJobs.remove(i)
			}
		}
	}
}
