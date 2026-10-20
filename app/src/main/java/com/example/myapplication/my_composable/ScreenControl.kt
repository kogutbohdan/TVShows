package com.example.myapplication.my_composable

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.my_packets.Show
import com.example.myapplication.my_packets.sort
import com.example.myapplication.view_models.SettingsViewModel
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

@Composable
fun ScreenControl(modifier: Modifier = Modifier,vm: SettingsViewModel= viewModel()){

    val client=remember{
        HttpClient(CIO){
            install(ContentNegotiation) {
                json(Json {
                    ignoreUnknownKeys = true
                })
            }
        }
    }


    var response by remember{mutableStateOf<List<Show>?>(null)}

    LaunchedEffect(Unit){
        try{
            response=sort(client.get("https://api.tvmaze.com/shows?pages=1").body<List<Show>>(),vm=vm)

        }catch(e:Exception){
            Log.e("TVSHOWS", "ERROR", e)
            response=null
        }
    }

    LaunchedEffect(vm.sortingType) {
        response= sort(response,vm=vm)
    }


    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = "cards"){
        composable(route = "cards") {
            WrapperComposable({
                Cards(modifier = Modifier.padding(it), response = response, navControler = navController)
            },navController=navController)
        }
        composable(route="settings") {
            WrapperComposable(children = {
                Settings(modifier=Modifier.padding(it))
            },navController=navController,home = false)
        }
        composable(route="show/{id}"){backStackEntry->
            val id=backStackEntry
                .arguments
                ?.getString("id")
                ?.toIntOrNull()

            Log.d("TVShow", "id = $id")

            val show=response?.find{
                it.id==id
            }

            if(show!=null){
                WrapperComposable({
                    TVShow(modifier = Modifier.padding(it), show = show)
                }, backbutton = true, home = false, navController = navController)
            }
        }
    }
}

