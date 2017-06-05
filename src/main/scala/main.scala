/**
	* Created by duane on 05/06/2017.
	*/
object main extends App {
	
	def main(): Unit ={
		println("Get gud")
	}
	
	var heyWorld: String = "Sup brah"
	
	def mainI(input: String): Unit ={
		println(input)
	}
	
	def introductions(name: String): Unit ={
		println(s"Hey there, $name")
	}
	
	def returnAny(input: Any): Any ={
		println(input)
	}
	
	def quadInput(phrase1: String, phrase2: String, letter1: Char, letter2: Char): Unit ={
		
		var _phrase:String = s"$phrase1, $phrase2"
		
		
		
	}
	
	main()
	mainI(heyWorld)
	introductions("Duane")
	
	returnAny(2.00)
	returnAny(6)
	returnAny("Hey man")
	returnAny(true)
	
	
	
}