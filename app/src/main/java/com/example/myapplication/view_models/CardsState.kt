package com.example.myapplication.view_models

import com.example.myapplication.my_packets.Show

data class CardsState(
    val shows: List<Show>? = null,
    val filter: String = "All",
    val error: String? = null
)
