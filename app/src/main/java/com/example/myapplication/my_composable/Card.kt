package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import com.example.myapplication.my_packets.Show


@Composable
fun Card(show:Show, modifier:Modifier=Modifier,onClick:()->Unit){
	Column(modifier=modifier.background(color=Color.LightGray,
										shape=RoundedCornerShape(30.dp)).padding(20.dp)
							.fillMaxWidth(0.95f)
							.clickable{
								onClick()
							}){
		CardsContent(show=show, modifier = Modifier.padding(top=20.dp))
	}
}