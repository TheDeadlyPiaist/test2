package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Employee(name:String, age:Int, annualWage:Float, jobRole:String) extends Person(name:String, age:Int) {
	
	super(name, age)
	private var _annualWage:Float = annualWage
	private var _jobRole = jobRole
	
	def setWage(nWage:Int): Unit ={
		_annualWage = nWage
	}
	
	def getWage(asString:Boolean=true): String = {
		if(asString) {
			return s"£$_annualWage"
		} else {
			return _annualWage.toString
		}
	}
	
	def setRole(nRole:String): Unit ={
		_jobRole = nRole
	}
	
	def getRole():String ={
		return _jobRole
	}
}
