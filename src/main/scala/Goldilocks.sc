def goldilocks(gWeight:Int, maxTemp:Int, chairs:List[Int]):Unit ={
	for(i <- chairs.indices by 2 if i < chairs.length) {
		if(gWeight < chairs(i) && maxTemp > chairs(i+1)) println("Chair: "+{i/2+1})
	}
}

goldilocks(100, 80, List(30, 50, 130, 75, 90, 60, 150, 85, 120, 70, 200, 200, 100, 100))
goldilocks(100, 120, List(
297, 90,
66, 110,
257, 113,
276, 191,
280, 129,
219, 163,
254, 193,
86, 153,
206, 147,
71, 137,
104, 40,
238, 127,
52, 146,
129, 197,
144, 59,
157, 124,
210, 59,
11, 54,
268, 119,
261, 121,
12, 189,
186, 108,
174, 21,
77, 18,
54, 90,
174, 52,
16, 129,
59, 181,
290, 123,
248, 132))