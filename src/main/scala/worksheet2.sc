var myList:Array[String] = java.util.TimeZone.getAvailableIDs
var newList = myList.map(a => a.split("/")).filter(a => a.length > 1).map(a => a.last).grouped(5).toArray