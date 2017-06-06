package garage

/**
	* Created by duane on 06/06/2017.
	*/
class Parts (name:String, replaceCost:Float, timeToFix:Float = 0, partList:Array[Parts]=null, bike:Boolean = true, broken:Boolean=false) {
	
	private var _name:String = name
	private var _replaceCost:Float = replaceCost
	private var _broken:Boolean = broken
	private var _timeToFix:Float = timeToFix
	private var _bike:Boolean = bike
	partList :+ this
	
	def setName(name:String): Unit ={
		_name = name
	}
	
	def getName(): String ={
		return _name
	}
	
	def setCost(cost:Float): Unit ={
		_replaceCost = cost
	}
	
	def getCost(): Unit ={
		return _replaceCost
	}
	
	def setState(broken:Boolean): Unit = {
		_broken = broken
	}
	
	def getState():Boolean ={
		return _broken
	}
	
	def setTimeToFix(input:Float): Unit ={
		_timeToFix = input
	}
	
	def getTimeToFix(): Float ={
		return _timeToFix
	}
	
	def getBike(): Boolean ={ //Check to see if the part can be put onto a bike
		return _bike
	}
	
}
