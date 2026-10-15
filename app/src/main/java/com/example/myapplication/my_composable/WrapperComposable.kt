package com.example.myapplication.my_composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WrapperComposable(children: @Composable (innerPadding: PaddingValues)->Unit, backbutton: Boolean=false,onClick:()->Unit={}){
    Scaffold(modifier = Modifier.fillMaxSize(),topBar={
        TopAppBar(
            title={
                Row(verticalAlignment = Alignment.CenterVertically) {
                    if(backbutton){
                        Button(onClick = onClick, modifier = Modifier.padding(end = 20.dp)) {
                            Text("Back")
                        }
                    }
                    Text("TVShow")
                }
            }
        )
    }) { innerPadding -> children(innerPadding)}
}