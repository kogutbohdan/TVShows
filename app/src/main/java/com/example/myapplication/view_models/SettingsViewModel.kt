package com.example.myapplication.view_models

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.my_storege.Storege
import kotlinx.coroutines.launch
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class SettingsViewModel(app: Application) : AndroidViewModel(app) {
    private val settings= Storege(app)
    var sortingType by mutableStateOf("rating")
        private set
    init{
        viewModelScope.launch {
            settings.sortingType.collect{
                sortingType=it
            }
        }
    }
    fun changeSortingType(value: String){
        viewModelScope.launch {
            settings.setSortingType(value = value)
        }
    }
}