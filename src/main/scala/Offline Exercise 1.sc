import scala.collection.mutable.ArrayBuffer

//============================================================Exercise 1

def doubleChar(input:String):String ={
	var output:String = ""
	input.foreach(i => output += s"$i$i")
	output
}

doubleChar("Hello")
doubleChar("Jelly")
doubleChar("That's how the cookie crumbles")

//============================================================Exercise 2

def sandwich(input:String):String = {
	var startIndex:Int = 0
	var finalIndex:Int = 0
	
	def getIndex(si:Int):Int ={
		var fin:Boolean = false
		var returnIndex:Int = 0
		for(i <- si until input.length if !fin) {
			if(input(i) == 'b' && input(i+1) == 'r' && input(i+2) == 'e' && input(i+3) == 'a' && input(i+4) == 'd') {
				returnIndex = i+5
				fin = true
			}
		}
		returnIndex
	}
	
	if(input.length > 10) startIndex = getIndex(0); finalIndex = getIndex(startIndex+1)-5
	
	if((startIndex == 0 && finalIndex == 0) || (startIndex != 0 && finalIndex == 0) || (startIndex < 0 || finalIndex < 0)) {
		"Doesn't work"
	} else if(startIndex == 0 && finalIndex == 5) {
		"That's not a sandwich. It's just bread. It's a bread sandwich."
	} else {
		input.substring(startIndex, finalIndex)
	}
}

sandwich("breadbaconbread")
sandwich("breadbread")
sandwich("bread")
sandwich("xasdbasdgebreadchocolatebreadklaskl")

//============================================================Exercise 3

def evenlySpaced(n1:Int, n2:Int, n3:Int):Boolean ={
	val numbers:ArrayBuffer[Int] = ArrayBuffer(n1, n2, n3).sorted
	val sep1:Int = numbers(1)-numbers(0)
	val sep2:Int = numbers(2)-numbers(1)
	if(sep1==sep2) true else false
}

evenlySpaced(2, 4, 6)
evenlySpaced(4, 6, 2)
evenlySpaced(4, 6, 3)

//============================================================Exercise 4

def fibonacci(input:Int):Int ={
	var sequence:ArrayBuffer[Int] = ArrayBuffer(0, 1, 1)
	def producePattern(n1:Int, n2:Int): Int ={
		n1+n2
	}
	def populate(input:Int):Unit ={
		for(i <- 2 to input) {
			val newNum = producePattern(sequence(i), sequence(i-1))
			sequence = sequence :+ newNum
		}
	}
	populate(input)
	sequence(input)
}

fibonacci(7)
fibonacci(1)
fibonacci(0)
fibonacci(36)
fibonacci(12)
fibonacci(5)

//============================================================Exercise 5

def bunnyEars(input:Int):Int ={
	if(input > 0) {
		2 + bunnyEars(input-1)
	} else {
		0
	}
}

bunnyEars(2)
bunnyEars(6)
bunnyEars(1)
bunnyEars(24)
bunnyEars(72)

//============================================================Exercise 6

def nTwice(text:String, n:Int):String ={
	val stringAsArray:Array[Char] = text.toArray
	var stringFront:String = ""
	var stringBack:String = ""
	for(i <- stringAsArray.indices) {
		if(i < n) {
			stringFront += stringAsArray(i)
		}
		if(i > stringAsArray.length-1-n) {
			stringBack += stringAsArray(i)
		}
	}
	stringFront + stringBack
}

nTwice("Woop", 1)
nTwice("firemalazer", 3)
nTwice("supercalafragilisticexpialidocious", 8)

//============================================================Exercise 7

def endsLy(input:String):Boolean ={
	if(input.length<2) false
	else {
		val end:String = input(input.length-2).toString + input(input.length-1).toString
		end match {
			case "ly" | "LY" | "Ly" | "lY" => true
			case _ => false
		}
	}
}

endsLy("Jelly")
endsLy("JELLY")
endsLy("J")
endsLy("Wompawompa")
endsLy("oddy")
endsLy("oddly")

//============================================================Exercise 8

def stringClean(input:String):String ={
	var returnString:String = ""
	def addChar(c:Char):Unit = returnString += c
	def searchString(index:Int):Unit = {
		var curChar:Char = input(index)
		var fin:Boolean = false
		addChar(curChar)
		for(i <- index until input.length if !fin) {
			if(input(i) != curChar) {
				searchString(i)
				fin = true
			}
		}
	}
	searchString(0)
	returnString
}

stringClean("xxyyzz")
stringClean("xxxyzzzzzz")
stringClean("hello")
stringClean("xxxxxuuuussssiiiiuuuuxxxxssss")

//============================================================Exercise 9

def printDiamond():Unit ={
	println(
		"""     /\
			|    /##\
			|   /####\
			|  /######\
			| /########\
			|/##########\
			|\##########/
			| \########/
			|  \######/
			|   \####/
			|    \##/
			|     \/""".stripMargin)
}

printDiamond()

//============================================================Exercise 10

def printEmptyDiamond():Unit ={
	println(
		"""     /\
			|    /  \
			|   /    \
			|  /      \
			| /        \
			|/          \
			|\          /
			| \        /
			|  \      /
			|   \    /
			|    \  /
			|     \/""".stripMargin)
}

printEmptyDiamond()