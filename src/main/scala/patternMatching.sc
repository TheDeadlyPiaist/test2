def columnOfLetters(input:String, length:Int, caseS:Int = 1): Unit = {
	
	var output:Any = ""
	var _caseS:Int = 0
	
	if(length == 0){
		_caseS = 0
	} else {
		_caseS = caseS
	}
	
	_caseS match {
			case 0 =>
			case 1 if length > 0 => println(input)
															columnOfLetters(input, length-1, _caseS)
	}
}


def swappingValues(input:Array[String]): Unit ={
	var u1 = input(0)
	var u2 = input(1)
	
	println(s"$u2,$u1")
	
}

var a = Array("a", "5")

columnOfLetters("a", 6)
swappingValues(a)