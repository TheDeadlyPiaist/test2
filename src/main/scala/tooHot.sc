//Code doesn't account for it being too cold

def checkTemperatue(temperature:Int, summer:Boolean=true): Unit ={
	var lb:Int = 60 //Lower Bound
	var ub:Int = 90 //Upper Bound
	var sl:Int = 100 //Summer Limit
	
	var tooHot:Boolean = false
	
	if(summer){
		if(temperature < sl){
			tooHot = false
		} else {
			tooHot = true
		}
	} else {
		if(temperature < ub && temperature > lb){
			tooHot = false
		} else { //If it is too hot
			tooHot = true
		}
	}
	println(tooHot)
}

checkTemperatue(93)
checkTemperatue(103)
checkTemperatue(45)
checkTemperatue(93, false)
checkTemperatue(56, false)