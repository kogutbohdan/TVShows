package com.example.myapplication.my_composable

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.myapplication.my_packets.Show


@Composable
fun CardsContent(show: Show, modifier: Modifier= Modifier.padding(top=20.dp)){
    AsyncImage(model=show.image.original,
        contentDescription="Зображення серіалу",
        onError = {
            Log.e("IMAGE", "Помилка", it.result.throwable)
        },
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(2f/3f)
    )

    Text(show.name, modifier=modifier,fontSize=30.sp,fontWeight=FontWeight.Bold)

    Row(modifier=modifier.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
        Text("year ${show.premiered}")
        Text("raiting ${show.rating.average}")
    }

    Text("status ${show.status}", modifier=modifier)

    if (show.genres.size>0){
        Column(modifier=modifier){
            Text("Genres",fontSize=20.sp,fontWeight=FontWeight.Bold)
            for (genre in show.genres){
                Text(genre,modifier=Modifier.padding(top=10.dp))
            }
        }
    }
}