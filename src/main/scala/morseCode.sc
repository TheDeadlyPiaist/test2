import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map
import sys.process._

var input:String = ".... . .-.. .-.. --- / -.. .- .. .-.. -.-- / .--. .-. --- --. .-. .- -- -- . .-. / --. --- --- -.. / .-.. ..- -.-. -.- / --- -. / - .... . / -.-. .... .- .-.. .-.. . -. --. . ... / - --- -.. .- -.--"
var morseCode:Array[String] = Array(".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", "/")
var alphaNumeric:Array[String] = Array("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", " ")
var output:String = ""

var indexKey: Map[String, String] = Map()


for(i <- morseCode.indices) {
	indexKey += (morseCode(i) -> alphaNumeric(i))
}

var wordArray:Array[String] = input.split(" ")
var outputArray:Array[String] = Array()

for(i <- wordArray.indices) {
	output = indexKey(wordArray(i))
	print(indexKey(wordArray(i)))
}


var wA:Array[String] = input.split(" ")
wA.foreach(a => indexKey(wA(a)))