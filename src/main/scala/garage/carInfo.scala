package garage

import scala.collection.mutable.ArrayBuffer

/**
	* Created by duane on 07/06/2017.
	*/
object carInfo {
	case class makeModel(make:String, model:String, car:Boolean=true) {
		private val _make = make
		private val _model = model
		
		def getMake():String ={
			_make
		}
		def getModel():String ={
			_model
		}
	}
	
	var vw1:makeModel = new makeModel("Volkswagen", "Golf")
	var vw2:makeModel = new makeModel("Volkswagen", "Polo")
	var vw3:makeModel = new makeModel("Volkswagen", "Passat")
	
	var jag1:makeModel = new makeModel("Jaguar", "XF")
	var jag2:makeModel = new makeModel("Jaguar", "XJ")
	var jag3:makeModel = new makeModel("Jaguar", "F-Type")
	
	var yam1:makeModel = new makeModel("Yamaha", "FZ25")
	var yam2:makeModel = new makeModel("Yamaha", "Saluto")
	var yam3:makeModel = new makeModel("Yamaha", "MT-09")
	
	val carList:ArrayBuffer[makeModel] = ArrayBuffer(vw1, vw2, vw3, jag1, jag2, jag3)
	val bikeList:ArrayBuffer[makeModel] = ArrayBuffer(yam1, yam2, yam3)
	
	var rand:Int = _
	var rMake:String = _
	var rModel:String = _
	var rArray:ArrayBuffer[String] = ArrayBuffer()
	def randomMM(car:Boolean=true): ArrayBuffer[String] ={
		if(car) {
			rand = Math.round(Math.random()*(carList.length-1)).toInt
			rMake = carList(rand).getMake()
			rModel = carList(rand).getModel()
			rArray = ArrayBuffer(rMake, rModel)
		} else {
			rand = Math.round(Math.random()*(bikeList.length-1)).toInt
			rMake = carList(rand).getMake()
			rModel = carList(rand).getModel()
			rArray = ArrayBuffer(rMake, rModel)
		}
		rArray
	}
}
