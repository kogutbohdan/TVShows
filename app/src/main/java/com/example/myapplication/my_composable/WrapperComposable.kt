package com.example.myapplication.my_composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WrapperComposable(children: @Composable (innerPadding: PaddingValues)->Unit, backbutton: Boolean=false,home: Boolean=true,navController: NavController){
    Scaffold(modifier = Modifier.fillMaxSize().fillMaxHeight(),topBar={
        TopAppBar(
            title={
                Text("TVShow")
            },
            navigationIcon = {
                if (backbutton) {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Назад"
                        )
                    }
                }
            } ,
            actions = {
                if(!home){
                    IconButton(onClick={
                        navController.navigate("cards")
                    }) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Головна"
                        )
                    }
                }
                IconButton(onClick = {
                    navController.navigate("settings")
                }) {
                    Icon(
                        imageVector = Icons.Default.Settings,
                        contentDescription = "Налаштування"
                    )
                }
            }
        )
    }) { innerPadding -> children(innerPadding)}
}