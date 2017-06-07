package garage

import scala.collection.mutable.ArrayBuffer

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
	var flyWheel:Parts = new Parts("Flywheel", 300, 90)
	var wingMirror:Parts = new Parts("Wing Mirror", 25, 20)
	var brakeCable:Parts = new Parts("Brake Cable", 15, 30)
	var cvJoint:Parts = new Parts("Constant Velocity Joint", 30, 30, false)
	var brakePad:Parts = new Parts("Brake Pad x4", 30, 20)
	var sparkPlug:Parts = new Parts("Spark Plug", 4, 10)
	var brakeDisc:Parts = new Parts("Brake Disc", 25, 30)
	var headlightUnit:Parts = new Parts("Headlight Unit", 20, 10)
	var brakeLightBulb:Parts = new Parts("Brake light bulb", 3, 10)
	var driveShaft:Parts = new Parts("Drive Shaft", 80, 40, false)
	var camBelt:Parts = new Parts("Cam Belt", 10, 20)
	
	var partList:ArrayBuffer[Parts] = ArrayBuffer(bearing, flyWheel, wingMirror, brakeCable, cvJoint, brakePad, sparkPlug, brakeDisc, headlightUnit, brakeLightBulb, driveShaft, camBelt)
	
	def getParts(car:Boolean=true): ArrayBuffer[Parts] ={
		var pList:ArrayBuffer[Parts] = partList
		var returnList:ArrayBuffer[Parts] = ArrayBuffer()
		
		if(car) {
			returnList = pList
		}	else {
			for(i <- pList.indices) {
				if(pList(i).getBike()) {
					returnList :+ pList(i)
				}
			}
		}
		return returnList
	}
	
}