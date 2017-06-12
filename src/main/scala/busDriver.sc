import scala.collection.mutable.ArrayBuffer

var busDrivers:ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer() // (Step, Knowledge)
var routes:ArrayBuffer[Int] = ArrayBuffer()
var minutesToDo:Int = 480
var positions:ArrayBuffer[Int] = ArrayBuffer()

def splitRoutes(input: String):Unit ={
	var routes:Array[String] = input.split("\n")
	routes.map(a => a.split(' '))
	for(i <- routes.indices) {
		positions :+ routes(i)(0)
		println(positions)
		//busDrivers = busDrivers :+ ArrayBuffer[Int](i)
	}
	
}

splitRoutes("""3 1 2 3
3 2 3 1
4 2 3 4 5""")