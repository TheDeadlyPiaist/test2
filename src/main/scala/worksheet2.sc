var myList:Array[String] = java.util.TimeZone.getAvailableIDs
var newList = myList.map(a => a.split("/")).filter(a => a.length > 1).map(a => a.last).grouped(5).toArray

def oncePerSecond(callback: Option[() => Unit] = None) {
	while(true) {timeflies(); Thread sleep 1000}
}

def timeflies(): Unit ={
	println("Time flies when you're having fun")
}

def f(x:Int) = x*2
def g(x: Int) = x+2
var input: Int = 3

var output:Int = (f _ andThen g)(input)


println(output)