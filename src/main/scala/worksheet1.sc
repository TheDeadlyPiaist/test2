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
	println(_phrase.replace(letter1, letter2))
	
}

def sumFunc(input1: Int, input2: Int, add: Boolean = true): Unit = {
	var output:Int = 0
	if(input1 != 0 && input2 != 0) {
		if(add) {
			output = input1 + input2
		} else {
			output = input1 * input2
		}
	} else {
		if(input1 == 0) {
			output = input2
		} else {
			output = input1
		}
	}
	println(s"$output")
}

def sheldonKnock(name: String, repeats: Int): Unit = {
	for(i<-1 to repeats){
		println(s"Hey $name")
	}
}

def rectangleLetters(letter: String, repeats: Int, rect:Boolean=true): Unit = {
	var letterRow:String = ""
	if(rect) {
		for(i <- 1 to repeats) {
			letterRow += s"$letter"
		}
		for(i <- 1 to repeats) {
			println(letterRow)
		}
	} else {
		for(i <- 1 to repeats) {
			letterRow += s"$letter"
		}
		var appendingLetters = letterRow
		for(i <- 1 to {repeats-1}) {
			letterRow += s"\n$appendingLetters"
		}
		println(letterRow)
	}
}

def stringMuddle(input1:String, input2:String, maxItteration:Int=1): Unit = {
	for(i <- 1 to maxItteration){
		var output: Any = ""
		if(i%3 == 0 && i%5 != 0){
			output = input1
		} else if(i%3 != 0 && i%5 == 0) {
			output = input2
		} else if(i%3 == 0 && i%5 == 0) {
			output = s"$input1$input2"
		} else {
			output = i
		}
		println(output)
	}
}

def repeatingLetterRec(input1:String, repeats:Int): Unit = {
	if(repeats > 0) {
		println(input1)
		repeatingLetterRec(input1, {repeats-1})
	}
}

def repeatingLettersSqRec(input1:String, repeats:Int, width:Int = 0): Unit = {
	
	var _width = 0
	var _repeats = repeats
	
	if(width != 0){
		_width = width
	} else {
		_width = repeats
	}
	
	var row:String = formRow(input1, _width)
	if(repeats > 0) {
		println(row)
		_repeats -= 1
		repeatingLettersSqRec(input1, _repeats, _width)
		
	}
}

def formRow(singleLetter:String, length:Int, fullString:String =""): String = {
	
	var _fullString:String = ""
	
	if(fullString != "") {
		_fullString = fullString
	}
	
	if(length>0){
		_fullString += singleLetter
		var _length = length-1
		formRow(singleLetter, _length, _fullString)
	} else {
		return _fullString
	}
}

def stringJumbleRec(input1:String, input2:String, length:Int, currentN:Int = 1): Unit = {
	var output:Any = ""
	if(currentN%3 == 0 && currentN%5 != 0){
		output = input1
	} else if(currentN%3 != 0 && currentN%5 == 0) {
		output = input2
	} else if(currentN%3 == 0 && currentN%5 == 0) {
		output = s"$input1$input2"
	} else {
		output = currentN
	}
	println(output)
	
	if(currentN < length) {
		stringJumbleRec(input1, input2, length - 1, currentN + 1)
	}
}

main()
mainI(heyWorld)
introductions("Duane")

returnAny(2.00)
returnAny(6)
returnAny("Hey man")
returnAny(true)

quadInput("If we take something, preferably text", "and we add them together like so", 'e', 'z')

sumFunc(4, 2)
sumFunc(6, 9)
sumFunc(4, 2, false)
sumFunc(6, 9, false)
sumFunc(0, 5)
sumFunc(3, 0)

sheldonKnock("Duane", 3)
sheldonKnock("Jake", 7)

rectangleLetters("r", 4)
rectangleLetters("r", 4, false)

stringMuddle("LEL", "KEK", 30)

repeatingLetterRec("A", 6)
repeatingLettersSqRec("B", 4)
stringJumbleRec("Jelly", "Fish", 30)