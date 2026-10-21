package com.example.myapplication.my_packets

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: ShowApiInterface=Retrofit.Builder()
        .baseUrl("https://api.tvmaze.com")
        .addConverterFactory(
            GsonConverterFactory.create()
        )
        .build()
        .create(ShowApiInterface::class.java)
}