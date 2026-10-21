package com.example.myapplication.my_packets

import retrofit2.http.GET

interface ShowApiInterface {
    @GET("/shows")
    suspend fun getShows(): List<Show>
}