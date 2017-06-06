package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Employee(name:String, age:Int, annualWage:Float, jobRole:String) extends Person(name:String, age:Int) {
	
	private var iAnnualWage:Float = annualWage
	private var iJobRole = jobRole
	
	def setWage(nWage:Int): Unit ={
		iAnnualWage = nWage
	}
	
	def getWage(asString:Boolean=true): String = {
		if(asString) {
			return s"£$iAnnualWage"
		} else {
			return iAnnualWage.toString
		}
	}
	
	def setRole(nRole:String): Unit ={
		iJobRole = nRole
	}
	
	def getRole():String ={
		return iJobRole
	}
}
