def functionA[t](input: t): Unit ={
	input match{
			case input:String => println("String")
			case input:Int => println("Integer")
			case _ => println("Not supported")
	}
}

functionA("Jelly fish": String)
functionA(4: Int)
functionA(7: Float)


def multipleInputs[t](items: t*): Unit ={
	items.foreach(items => println(items))
}

multipleInputs(1, 2, 3, 4, 5)

var militaryAge = 16
val isOfMilitaryAge = (age: Int) => age >= militaryAge

def printResult(f: Int => Boolean, x:Int): Unit ={
	println(s"Is above military age: $militaryAge, " + f(x))
}

printResult(isOfMilitaryAge, 17)