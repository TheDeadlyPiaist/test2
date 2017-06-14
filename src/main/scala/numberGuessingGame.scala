import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 13/06/2017.
	*/
object numberGuessingGame extends App{
	
	var userNumber:Int = 0
	var initNumbers:Array[Int] = (1 to 1000).toArray
	var currentNumbers:ArrayBuffer[Int] = ArrayBuffer()
	//var input = scala.io.StdIn.readLine()
	var numberLearning:Int = 500
	var guesses:Int = 0
	
	initArray()
	
	def initArray():Unit ={
		initNumbers.copyToBuffer(currentNumbers)
		guesses = 0
		println("Pick a number between 1 - 1000")
		userNumber = scala.io.StdIn.readLine().toInt
		guessN(numberLearning)
	}
	def guessN(guess:Int):Unit ={
		def userInput(input:String):Unit = {
			input match {
				case "Higher" | "higher" | "h" if userNumber>guess => currentNumbers = currentNumbers.filter(_ > guess)
				case "Higher" | "higher" | "h" if userNumber<guess => println("I think you're lying to me");printTroll()
				case "Lower" | "lower" | "l" if userNumber<guess => currentNumbers = currentNumbers.filter(_ < guess)
				case "Lower" | "lower" | "l" if userNumber>guess => println("I think you're lying to me");printTroll()
				case _ => println("That us not a valid input. Try: Higher or Lower")
					var newInput:String = scala.io.StdIn.readLine()
					userInput(newInput)
			}
		}
		if(guess == userNumber) {
			printSuccess()
			println(s"Your number, is $guess! It took me $guesses guesses!")
			println(s"Another game?")
			var newGame:String = scala.io.StdIn.readLine()
			newGame match {
				case "yes" | "Yes" | "y" | "Y" => numberLearning = (numberLearning+guess)/2; initArray();
				case "no" | "No" | "n" | "N" =>
				case _ =>
			}
		} else {
			guesses += 1
			println(s"I have chosen $guess, higher or lower?")
			var uInput:String = scala.io.StdIn.readLine()
			userInput(uInput)
			var nextGuess:Int = currentNumbers(currentNumbers.length / 2)
			guessN(nextGuess)
		}
	}
	
	def printTroll():Unit ={
		println("""░░░░▄▄▄▄▀▀▀▀▀▀▀▀▄▄▄▄▄▄
░░░█░░░░▒▒▒▒▒▒▒▒▒▒▒▒░░▀▀▄
░░█░░░▒▒▒▒▒▒░░░░░░░░▒▒▒░░█
░█░░░░░░▄██▀▄▄░░░░░▄▄▄░░░█
█░▄▄▄▒░█▀▀▀▀▄▄█░░░██▄▄█░░░█
█░▒▄░▀▄▄▄▀░░░░░░░░█░░░▒▒▒▒▒█
█░░░█▄░█▀▄▄░▀░▀▀░▄▄▀░░░░█░░█
░█░░▀▄▀█▄▄░█▀▀▀▄▄▄▄▀▀█▀██░█
░░█░░██░░▀█▄▄▄█▄▄█▄████░█
░░░█░░░▀▀▄░█░░░█░███████░█
░░░░▀▄░░░▀▀▄▄▄█▄█▄█▄█▄▀░░█
░░░░░░▀▄▄░▒▒▒▒░░░░░░░░░░█
░░░░░░░░█▀▀▄▄░▒▒▒▒▒▒▒▒▒▒░█
░░░░░░░░█░░░░▀▄▄▄▄▄▄▄▄▄▄█""")
	}
	def printSuccess():Unit ={
		println(
"""░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░
░░░░░░░▄▄▀▀▀▀▀▀▀▀▀▀▄▄█▄░░░░▄░░░░█░░░░░░░
░░░░░░█▀░░░░░░░░░░░░░▀▀█▄░░░▀░░░░░░░░░▄░
░░░░▄▀░░░░░░░░░░░░░░░░░▀██░░░▄▀▀▀▄▄░░▀░░
░░▄█▀▄█▀▀▀▀▄░░░░░░▄▀▀█▄░▀█▄░░█▄░░░▀█░░░░
░▄█░▄▀░░▄▄▄░█░░░▄▀▄█▄░▀█░░█▄░░▀█░░░░█░░░
▄█░░█░░░▀▀▀░█░░▄█░▀▀▀░░█░░░█▄░░█░░░░█░░░
██░░░▀▄░░░▄█▀░░░▀▄▄▄▄▄█▀░░░▀█░░█▄░░░█░░░
██░░░░░▀▀▀░░░░░░░░░░░░░░░░░░█░▄█░░░░█░░░
██░░░░░░░░░░░░░░░░░░░░░█░░░░██▀░░░░█▄░░░
██░░░░░░░░░░░░░░░░░░░░░█░░░░█░░░░░░░▀▀█▄
██░░░░░░░░░░░░░░░░░░░░█░░░░░█░░░░░░░▄▄██
░██░░░░░░░░░░░░░░░░░░▄▀░░░░░█░░░░░░░▀▀█▄
░▀█░░░░░░█░░░░░░░░░▄█▀░░░░░░█░░░░░░░▄▄██
░▄██▄░░░░░▀▀▀▄▄▄▄▀▀░░░░░░░░░█░░░░░░░▀▀█▄
░░▀▀▀▀░░░░░░░░░░░░░░░░░░░░░░█▄▄▄▄▄▄▄▄▄██
░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░"""
		)
	}
}
