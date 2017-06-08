package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Person(name:String, age:Int) {
	
	private var iName:String = name
	private var iAge:Int = age
	
	def setName(name:String): Unit = {
		iName = name
	}
	
	def getName(): String = {
		return iName
	}
	
	def setAge(age:Int): Unit ={
		iAge = age
	}
	
	def getAge(): Int ={
		return iAge
	}
	
	override def toString():String = {
		s"Name:$iName Age:$iAge"
	}
}
