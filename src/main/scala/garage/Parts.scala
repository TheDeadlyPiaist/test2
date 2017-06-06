package garage

/**
	* Created by duane on 06/06/2017.
	*/
class Parts (name:String, replaceCost:Float) {
	var bearing:Parts = new Parts("Bearing", 10)
	var flyWheel:Parts = new Parts("Flywheel", 300)
	var wingMirror:Parts = new Parts("Wing Mirror", 25)
	var brakeCable:Parts = new Parts("Brake Cable", 15)
	var cvJoint:Parts = new Parts("Constant Velocity Joint", 30)
	var brakePad:Parts = new Parts("Brake Pad x4", 30)
	var sparkPlug:Parts = new Parts("Spark Plug", 4)
	var brakeDisc:Parts = new Parts("Brake Disc", 25)
	var headlightUnit:Parts = new Parts("Headlight Unit", 20)
	var brakeLightBulb:Parts = new Parts("Brake light bulb", 3)
	
	def allParts:Array[Parts] = (null)
	
	def Parts(): Unit ={
		allParts :+ this
	}
	println(allParts)
}
