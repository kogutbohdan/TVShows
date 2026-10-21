package com.example.myapplication.view_models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.my_packets.RetrofitInstance
import com.example.myapplication.my_packets.Show
import kotlinx.coroutines.launch

class CardsViewModel : ViewModel() {
    var cardsState by  mutableStateOf(CardsState())
        private set

    fun setCardsState(shows : List<Show>?=null, filter:String?=null, interval: List<Int>?=null){
        cardsState = cardsState.copy(
            shows = shows ?: cardsState.shows,
            filter = filter ?: cardsState.filter,
            interval = interval ?: cardsState.interval,
        )
    }
}