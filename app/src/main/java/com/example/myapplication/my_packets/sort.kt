package com.example.myapplication.my_packets


fun sort(list: List<Show>?, sortingType: String?): List<Show>? {
    return when(sortingType){
        "rating"->list?.sortedByDescending { it.rating.average }
        "date"->list?.sortedByDescending { it.premiered }
        "date_old"->list?.sortedBy { it.premiered }
        else -> list?.sortedBy { it.name }
    }
}