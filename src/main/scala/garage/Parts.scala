package garage

/**
	* Created by duane on 06/06/2017.
	*/
class Parts (name:String, replaceCost:Float, broken:Boolean=false) {
	
	private var _name:String = name
	private var _replaceCost:Float = replaceCost
	private var _broken:Boolean = broken
	
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
	
}
