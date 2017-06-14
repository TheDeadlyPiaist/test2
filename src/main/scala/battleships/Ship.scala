package battleships

abstract class Ship(name:String, length:Int) {
	private var iName:String = name
	private var iLength:Int = length
	def getName:String = iName
	def getLength:Int = iLength
}
object Ship {
	case class patrolBoat(name:String = "Patrol Boat", length:Int = 2) extends Ship(name, length)
	case class destroyer(name:String = "Destroyer", length:Int = 3) extends Ship(name, length)
	case class submarine(name:String = "Submarine", length:Int = 3) extends Ship(name, length)
	case class battleship(name:String = "Battleship", length:Int = 4) extends Ship(name, length)
	case class aircraftcarrier(name:String = "Aircraft Carrier", length:Int) extends Ship(name, length)
}