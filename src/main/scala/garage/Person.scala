package garage

/**
	* Created by duane on 05/06/2017.
	*/
class Person(name:String, age:Int) {
	
	private var _name:String = name
	private var _age:Int = age
	
	def setName(name:String): Unit = {
		_name = name
	}
	
	def getName(): String = {
		return _name
	}
	
	def setAge(age:Int): Unit ={
		_age = age
	}
	
	def getAge(): Int ={
		return _age
	}
	
	override def toString():String = {
		return s"$_name $_age"
	}
}
