package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.my_packets.Show
import com.example.myapplication.view_models.CardsViewModel


@Composable
fun Cards(
	modifier: Modifier = Modifier,
	vm: CardsViewModel = viewModel(),
	response: List<Show>?,
	navControler: NavHostController
){

	val scrollState=rememberScrollState()

	LaunchedEffect(response, vm.cardsState.filter){
		if(vm.cardsState.filter!="All"){
			vm.setCardsState(
                shows = response?.filter {
                    vm.cardsState.filter in it.genres
                }
            )
		}else{
			vm.setCardsState(shows=response)
		}
	}
	
	Column(modifier=modifier){
		Filters()
		Column(horizontalAlignment=Alignment.CenterHorizontally,
			verticalArrangement=Arrangement.spacedBy(16.dp),
			modifier=Modifier.fillMaxWidth().verticalScroll(scrollState)){
	
			val currentResponse = vm.cardsState.shows
			

			if(currentResponse!=null){
				for(show in currentResponse.subList(vm.cardsState.interval[0],minOf(vm.cardsState.interval[1],currentResponse.size))){
					Card(show,onClick={
						navControler.navigate("show/${show.id}")
					})
				}
			}else{
				Text("Нема інету")
			}
			//Card(Show(1,"","English","Move",Rating(28.0),arrayOf("1","2","3"),"running","2026"))
		}
	}
}