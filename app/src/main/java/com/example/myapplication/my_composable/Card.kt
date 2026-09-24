package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material3.Text
import android.util.Log
import coil3.compose.AsyncImage
import androidx.compose.foundation.layout.padding
import com.example.myapplication.R
import com.example.myapplication.my_packets.Show


@Composable
fun Card(show:Show, modifier:Modifier=Modifier){
	val marginTop=Modifier.padding(top=20.dp)
	Column(modifier=modifier.background(color=Color.LightGray,
										shape=RoundedCornerShape(30.dp)).padding(20.dp).fillMaxWidth(0.95f)){
		//Image(painter=painterResource(R.drawable.tryimg),contentDescription="try")
		AsyncImage(model=show.image.original,
			contentDescription="Зображення серіалу",
			onError = {
        		Log.e("IMAGE", "Помилка", it.result.throwable)
    		},
    		modifier = Modifier
        				.fillMaxWidth()
        				.aspectRatio(2f/3f)
    	)

		Text(show.name, modifier=marginTop,fontSize=30.sp,fontWeight=FontWeight.Bold)

		Row(modifier=marginTop.fillMaxWidth(),horizontalArrangement=Arrangement.SpaceBetween){
			Text("year ${show.premiered}")
			Text("raiting ${show.rating.average}")
		}

		Text("status ${show.status}", modifier=marginTop)


		if (show.genres.size>0){
			Column(modifier=marginTop){
				Text("Genres",fontSize=20.sp,fontWeight=FontWeight.Bold)
				for (genre in show.genres){
					Text(genre,modifier=Modifier.padding(top=10.dp))
				}
			}
		}
	}
}