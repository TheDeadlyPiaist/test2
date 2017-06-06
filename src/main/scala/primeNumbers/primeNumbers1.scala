package primeNumbers

object primeNumbers1 extends App {
	var checkedPrimes = Array[Int]()
	var start:Int = 5
	var end:Int = 3000000
	
	checkedPrimes = checkedPrimes :+ 2
	checkedPrimes = checkedPrimes :+ 3
	
	for (i <- start to end by 2) {
		var checked:Boolean = false
		for(j <- 0 until checkedPrimes.length; if !checked) {
			var calc:Float = i % checkedPrimes(j)
			if(calc == 0) {
				checked = true
			}
		}
		if(!checked) {
			checkedPrimes = checkedPrimes :+ i
			println(i)
		}
		
	}
	
	println("Finished")
	
}
