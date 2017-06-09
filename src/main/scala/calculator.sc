import scala.collection.mutable.ArrayBuffer

def calculator3(n:Double*): Unit ={
	var numbers:ArrayBuffer[Double] = ArrayBuffer()
	n.foreach(a => numbers = numbers :+ a)
	numbers = numbers.sorted
	if(numbers.length > 2) {
		for(i <- numbers.indices) {
			var checkArray:ArrayBuffer[Double] = ArrayBuffer()
			numbers.copyToBuffer(checkArray)
			checkArray.remove(i)
			calculate(checkArray, numbers(i))
		}
	} else {
		println("There are not enough numbers")
	}
}
def calculate(arrayBuffer: ArrayBuffer[Double], answer:Double): Unit = {
	if(arrayBuffer.length == 2) {
		var buff = arrayBuffer
		var n1:Double = buff(0)
		var n2:Double = buff(1)
		if(n1 + n2 == answer) {
			println(s"$n1 + $n2 = $answer")
		}
		if(n1 - n2 == answer) {
			println(s"$n1 - $n2 = $answer")
		}
		if(n1 * n2 == answer) {
			println(s"$n1 * $n2 = $answer")
		}
		if(n1 / n2 == answer) {
			println(s"$n1 / $n2 = $answer")
		}
		/*if(n2 + n1 == answer) {
			println(s"$n2 + $n1 = $answer")
		}*/
		if(n2 - n1 == answer) {
			println(s"$n2 - $n1 = $answer")
		}
		/*if(n2 * n1 == answer) {
			println(s"$n2 * $n1 = $answer")
		}*/
		if(n2 / n1 == answer) {
			println(s"$n2 / $n1 = $answer")
		}
	} else {
		for(i <- arrayBuffer.indices) {
			var inArray:ArrayBuffer[Double] = ArrayBuffer()
			arrayBuffer.copyToBuffer(inArray)
			inArray.remove(i)
			calculate(inArray, arrayBuffer(i))
		}
	}
}

calculator3(2, 5, 2.5, 10, 4)