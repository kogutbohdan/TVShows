package com.example.myapplication.my_packets

import com.example.myapplication.view_models.SettingsViewModel


fun sort(list: List<Show>?, vm: SettingsViewModel): List<Show>? {
    return when(vm.sortingType){
        "rating"->list?.sortedByDescending { it.rating.average }
        "date"->list?.sortedByDescending { it.premiered }
        "date_old"->list?.sortedBy { it.premiered }
        else -> list?.sortedBy { it.name }
    }
}