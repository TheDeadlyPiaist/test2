package garage

/**
	* Created by duane on 06/06/2017.
	*/
case class Parts(name:String, replaceCost:Float, timeToFix:Float = 0, bike:Boolean = true, broken:Boolean=false) {
	
	private var iName:String = name
	private var iReplaceCost:Float = replaceCost
	private var iTimeToFix:Float = timeToFix
	private var iBike:Boolean = bike
	private var iBroken:Boolean = broken
	
	def setName(inName:String):Unit = {
		iName = inName
	}
	
	def getName():String = {
		iName
	}
	
	def setCost(inCost:Float):Unit = {
		iReplaceCost = inCost
	}
	
	def getCost():Float = {
		iReplaceCost
	}
	
	def setState(inBroken:Boolean):Unit = {
		iBroken = inBroken
	}
	
	def getState():Boolean = {
		iBroken
	}
	
	def setTimeToFix(inTimeToFix:Float):Unit = {
		iTimeToFix = inTimeToFix
	}
	
	def getTimeToFix():Float = {
		iTimeToFix
	}
	
	def getBike():Boolean = { //Check to see if the part can be put onto a bike
		iBike
	}
}