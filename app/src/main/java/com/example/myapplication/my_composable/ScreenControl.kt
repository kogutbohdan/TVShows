package com.example.myapplication.my_composable

import android.util.Log
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.view_models.ResponseViewModel
import com.example.myapplication.view_models.SettingsViewModel


@Composable
fun ScreenControl(modifier: Modifier = Modifier, responseVM: ResponseViewModel=viewModel(), vm: SettingsViewModel= viewModel()){

    LaunchedEffect(vm.sortingType,responseVM.responseState.response) {responseVM.resort(vm.sortingType)}


    val navController= rememberNavController()

    NavHost(navController = navController, startDestination = "cards",modifier= Modifier.fillMaxHeight()){
        composable(route = "cards") {
            WrapperComposable({
                Cards(modifier = Modifier.padding(it), responseVM = responseVM, navControler = navController)
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

            val show=responseVM.responseState.response?.find{
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

