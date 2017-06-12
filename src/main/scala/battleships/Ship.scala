package battleships

abstract class Ship(name:String, length:Int) {
	private var iName:String = name
	private var iLength:Int = length
	def getName:String = iName
	def getLength:Int = iLength
}
object Ship {
	private class patrolBoat(name:String, length:Int) extends Ship(name, length)
	private class destroyer(name:String, length:Int) extends Ship(name, length)
	private class submarine(name:String, length:Int) extends Ship(name, length)
	private class battleship(name:String, length:Int) extends Ship(name, length)
	private class aircraftcarrier(name:String, length:Int) extends Ship(name, length)
	
	def newPatrolBoat = new patrolBoat("Patrol Boat", 2)
	def newDestroyer = new destroyer("Destroyer", 3)
	def newSubmarine = new submarine("Submarine", 3)
	def newBattleship = new battleship("Battleship", 4)
	def newAircraftCarrier = new aircraftcarrier("Aircraft Carrier", 5)
}
