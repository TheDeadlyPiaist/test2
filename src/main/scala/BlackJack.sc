def blackJack(n1:Int, n2:Int): Unit = {
	var output:Int = 0
	if(n1 <= 21 && n2 <= 21){
		if(n1 < n2) {
			output = n2
		} else if(n1 > n2) {
			output = n1
		}
	} else {
		if(n1 > 21) {
			output = n2
		} else if(n2 > 21) {
			output = n1
		}
	}
	println(output)
}

blackJack(11, 11)
blackJack(11, 23)
blackJack(24, 12)
blackJack(22, 23)
blackJack(11, 13)
blackJack(14, 20)