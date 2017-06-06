package garage

/**
	* Created by duane on 06/06/2017.
	*/
class PartList {
	
	var totalParts:Array[Parts] = ()
	
	var bearing:Parts = new Parts("Bearing", 10, 20, totalParts)
	var flyWheel:Parts = new Parts("Flywheel", 300, 180, totalParts)
	var wingMirror:Parts = new Parts("Wing Mirror", 25, 40, totalParts)
	var brakeCable:Parts = new Parts("Brake Cable", 15, 30, totalParts)
	var cvJoint:Parts = new Parts("Constant Velocity Joint", 30, 40, totalParts, false)
	var brakePad:Parts = new Parts("Brake Pad x4", 30, 20, totalParts)
	var sparkPlug:Parts = new Parts("Spark Plug", 4, 15, totalParts)
	var brakeDisc:Parts = new Parts("Brake Disc", 25, 50, totalParts)
	var headlightUnit:Parts = new Parts("Headlight Unit", 20, 20, totalParts)
	var brakeLightBulb:Parts = new Parts("Brake light bulb", 3, 10, totalParts)
	
	
	
}
