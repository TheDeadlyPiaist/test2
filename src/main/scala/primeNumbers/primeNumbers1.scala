package primeNumbers

object primeNumbers1 extends App {
	
	var checkedPrimes = Array[Int]()
	var start:Int = 5
	var end:Int = 3000000
	
	checkedPrimes = checkedPrimes :+ 2
	checkedPrimes = checkedPrimes :+ 3
	
	for (i <- start to end by 2) {
		var checked:Boolean = false
		var j:Int = 0
		while(!checked && checkedPrimes(j) < Math.sqrt(i)) {
			j += 1
			if(i%checkedPrimes(j) == 0) {
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
