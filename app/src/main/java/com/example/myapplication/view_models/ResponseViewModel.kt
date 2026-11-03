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
import retrofit2.HttpException
import java.io.IOException

class ResponseViewModel: ViewModel() {
    var responseState: ResponseState by mutableStateOf(ResponseState())
        private set

    init{
        reloadShows()
    }

    fun reloadShows(){
        responseState= responseState.copy(
            error = null
        )
        viewModelScope.launch {
            try{
                responseState= responseState.copy(response = RetrofitInstance.api.getShows())
            }catch(e: IOException){
                Log.e("TVSHOWS", "ERROR", e)
                responseState= responseState.copy(
                    response = null,
                    error = "Немає підключення до інтернету"
                )
            }catch(e: HttpException){
                responseState= responseState.copy(
                    response = null,
                    error = "Невдалося завантажити серіали спробуйте пізніше"
                )
            }
        }
    }
    fun resort(sortingType: String?){
        responseState=responseState.copy(response=sort(responseState.response, sortingType = sortingType))
    }
}