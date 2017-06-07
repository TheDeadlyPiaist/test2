package primeNumbers

import primeNumbers.primeNumbers1.{checkedPrimes, start}

object primeNumbers2 extends App {
	
	var checkedPrimes = Array[Int]()
	var start:Int = 5
	var end:Int = 2000000000
	
	checkedPrimes = checkedPrimes :+ 2
	checkedPrimes = checkedPrimes :+ 3
	
	var checked:Boolean = false
	var i:Int = start
	var j:Int = 0
	
	while (i < end) {
		j = 0
		checked = false
		while(!checked && checkedPrimes(j) < Math.sqrt(i)) {
			j += 1
			i%checkedPrimes(j) match {
					case 0 => checked = true
					case _ =>
			}
		}
		i += 2
		if(!checked) {
			checkedPrimes = checkedPrimes :+ i
			println(i)
		}
	}
	println("Finished")
}
