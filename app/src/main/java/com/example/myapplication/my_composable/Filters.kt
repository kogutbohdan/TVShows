package com.example.myapplication.my_composable


import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.view_models.CardsViewModel

@Composable
fun Filters(modifier:Modifier=Modifier,vm: CardsViewModel = viewModel()){
	val scroll=rememberScrollState()

	val genres=listOf(
			"All",
	    	"Action",
	        "Adventure",
	        "Anime",
	        "Comedy",
	        "Crime",
	        "Drama",
	        "Espionage",
	        "Family",
	        "Fantasy",
	        "History",
	        "Horror",
	        "Legal",
	        "Medical",
	        "Music",
	        "Mystery",
	        "Romance",
	        "Science-Fiction",
	        "Sports",
	        "Supernatural",
	        "Thriller",
	        "War",
	        "Western",
	)

	Row(modifier=modifier.horizontalScroll(scroll),
		horizontalArrangement=Arrangement.spacedBy(5.dp)){
		for(genre in genres){
			Button(onClick={vm.setCardsState(filter = genre)}){
				Text(genre)
			}
		}
	}
}