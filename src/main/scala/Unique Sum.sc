import scala.collection.mutable.ArrayBuffer

def uniqueSum(n1:Int, n2:Int, n3:Int): Unit = {
	var numbers:ArrayBuffer[Int] = ArrayBuffer(n1, n2, n3)
	var output:Int = 0
	
	if(n1 == n2 || n1 == n3) {
		numbers -= n1
	}
	if(n2 == n3) {
		numbers -= n2
	}
	for(i <- 0 to numbers.length-1){
		output += numbers(i)
	}
	println(output)
}

uniqueSum(1, 3, 7)