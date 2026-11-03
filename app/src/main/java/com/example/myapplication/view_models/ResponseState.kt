package com.example.myapplication.view_models

import com.example.myapplication.my_packets.Show

data class ResponseState(
    val response:List<Show>?=null,
    val error:String?=null
)