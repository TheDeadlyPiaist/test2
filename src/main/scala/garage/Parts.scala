package garage

/**
	* Created by duane on 06/06/2017.
	*/
class Parts (name:String, replaceCost:Float, timeToFix:Float = 0, partList:Array[Parts]=null, bike:Boolean = true, broken:Boolean=false) {
	
	private var iName:String = name
	private var iReplaceCost:Float = replaceCost
	private var iBroken:Boolean = broken
	private var iTimeToFix:Float = timeToFix
	private var iBike:Boolean = bike
	partList :+ this
	
	def setName(name:String): Unit ={
		iName = name
	}
	
	def getName(): String ={
		return iName
	}
	
	def setCost(cost:Float): Unit ={
		iReplaceCost = cost
	}
	
	def getCost(): Float ={
		return iReplaceCost
	}
	
	def setState(broken:Boolean): Unit = {
		iBroken = broken
	}
	
	def getState():Boolean ={
		return iBroken
	}
	
	def setTimeToFix(input:Float): Unit ={
		iTimeToFix = input
	}
	
	def getTimeToFix(): Float ={
		return iTimeToFix
	}
	
	def getBike(): Boolean ={ //Check to see if the part can be put onto a bike
		return iBike
	}
	
}
