package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import android.util.Log
import com.example.myapplication.my_composable.Card
import com.example.myapplication.my_composable.Filters
import com.example.myapplication.my_packets.Show
import com.example.myapplication.my_packets.ShowResponse
import com.example.myapplication.my_packets.Rating
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.get
import io.ktor.client.call.body
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import io.ktor.client.statement.bodyAsText



@Composable
fun Cards(modifier:Modifier=Modifier){
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
	var shows by remember{mutableStateOf<List<Show>?>(null)}
	var interval by remember{mutableStateOf(listOf(0,20))}
	var filter by remember{mutableStateOf<String>("All")}
	val scrollState=rememberScrollState()

	LaunchedEffect(Unit){
		try{
			response=client.get("https://api.tvmaze.com/shows?pages=0").body<List<Show>>()
		}catch(e:Exception){
			Log.e("TVSHOWS", "ERROR", e)
			response=null
		}
	}

	LaunchedEffect(response,filter){
		if(filter!="All"){
			shows=response?.filter{
				filter in it.genres
			}
		}else{
			shows=response
		}
	}
	
	Column(modifier=modifier){
		Filters(changeFilter={
			filter=it
		})
		Column(horizontalAlignment=Alignment.CenterHorizontally,
			verticalArrangement=Arrangement.spacedBy(16.dp),
			modifier=Modifier.fillMaxWidth().verticalScroll(scrollState)){
	
			val currentResponse = shows
			

			if(currentResponse!=null){
				for(show in currentResponse.subList(interval[0],minOf(interval[1],currentResponse.size))){
					Card(show)
				}
			}else{
				Text("Нема інету")
			}
			//Card(Show(1,"","English","Move",Rating(28.0),arrayOf("1","2","3"),"running","2026"))
		}
	}
}