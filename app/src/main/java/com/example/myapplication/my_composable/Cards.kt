package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.myapplication.my_composable.Card
import com.example.myapplication.my_packets.Show
import com.example.myapplication.my_packets.Rating




@Composable
fun Cards(modifier:Modifier){
	Column(horizontalAlignment=Alignment.CenterHorizontally,
		modifier=modifier.fillMaxWidth()){
		Card(Show(1,"","English","Move",Rating(28.0),arrayOf("1","2","3"),"running","2026"))
	}
}