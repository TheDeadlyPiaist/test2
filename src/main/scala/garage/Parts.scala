package garage

/**
	* Created by duane on 06/06/2017.
	*/

object Parts {
	
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
	
	var bearing:Parts = new Parts("Bearing", 10, 20)
	var flyWheel:Parts = new Parts("Flywheel", 300, 180)
	var wingMirror:Parts = new Parts("Wing Mirror", 25, 40)
	var brakeCable:Parts = new Parts("Brake Cable", 15, 30)
	var cvJoint:Parts = new Parts("Constant Velocity Joint", 30, 40, false)
	var brakePad:Parts = new Parts("Brake Pad x4", 30, 20)
	var sparkPlug:Parts = new Parts("Spark Plug", 4, 15)
	var brakeDisc:Parts = new Parts("Brake Disc", 25, 50)
	var headlightUnit:Parts = new Parts("Headlight Unit", 20, 20)
	var brakeLightBulb:Parts = new Parts("Brake light bulb", 3, 10)
	
}