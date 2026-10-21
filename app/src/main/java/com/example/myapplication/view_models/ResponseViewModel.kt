package com.example.myapplication.view_models

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import com.example.myapplication.my_packets.RetrofitInstance
import com.example.myapplication.my_packets.Show
import com.example.myapplication.my_packets.sort
import kotlinx.coroutines.launch

class ResponseViewModel: ViewModel() {
    var response: List<Show>? by mutableStateOf(null)
        private set

    init{
        viewModelScope.launch {
            try{
                response = RetrofitInstance.api.getShows()
            }catch(e:Exception){
                Log.e("TVSHOWS", "ERROR", e)
                response = null
            }
        }
    }

    fun resort(sortingType: String?){
        response=sort(response, sortingType = sortingType)
    }
}