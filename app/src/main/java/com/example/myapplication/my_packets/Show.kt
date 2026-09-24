package com.example.myapplication.my_packets

import kotlinx.serialization.Serializable

@Serializable
data class Rating(
	val average:Double?
)

@Serializable
data class Image(
	val medium:String,
	val original:String
)

@Serializable
data class Show(
	val id:Int,
	val url:String,
	val language:String,
	val name:String,
	val rating:Rating,
	val genres:List<String>,
	val status:String,
	val premiered:String,
	val image:Image
)

@Serializable
data class ShowResponse(
	val score:Double,
	val show:Show
)