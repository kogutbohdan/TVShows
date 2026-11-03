package com.example.myapplication.my_composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.view_models.ResponseViewModel
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.graphics.Color
import java.nio.file.WatchEvent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding


@Composable
fun MassageAboutError(error: String,responseVM: ResponseViewModel){
    val topPadding= Modifier.padding(top=20.dp)
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier) {
        Text(error, modifier = topPadding)
        Button(onClick = {
            responseVM.reloadShows()
        },modifier=topPadding) {
            Text("Спробуйте щераз")
        }
    }
}