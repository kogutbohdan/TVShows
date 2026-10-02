package com.example.myapplication.view_models

import com.example.myapplication.my_packets.Show

data class CardsState(
    val shows: List<Show>? = null,
    val interval: List<Int> = listOf(0,20),
    val filter: String = "All"
)
