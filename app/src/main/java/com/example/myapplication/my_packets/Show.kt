package com.example.myapplication.my_packets


data class Rating(
	val average:Double
)


data class Image(
	val medium:String,
	val original:String
)

data class Show(
	val id:Int,
	val url:String,
	val languag:String,
	val name:String,
	val rating:Rating,
	val genres:Array<String>,
	val status:String,
	val premiered:String
)


data class ShowResponse(
	val score:Double,
	val show:Show
)