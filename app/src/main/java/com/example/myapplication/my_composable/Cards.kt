package com.example.myapplication.my_composable

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.myapplication.my_packets.Show
import com.example.myapplication.view_models.CardsViewModel
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import com.example.myapplication.view_models.ResponseViewModel

@Composable
fun Cards(
	modifier: Modifier = Modifier,
	vm: CardsViewModel = viewModel(),
	responseVM: ResponseViewModel = viewModel(),
	navControler: NavHostController
){

	LaunchedEffect(responseVM.responseState.response, vm.cardsState.filter){
		if(vm.cardsState.filter!="All"){
			vm.setCardsState(
                shows = responseVM.responseState.response?.filter {
                    vm.cardsState.filter in it.genres
                }
            )
		}else{
			vm.setCardsState(shows=responseVM.responseState.response)
		}
	}

	Column(modifier=modifier){
		Filters(vm=vm)
		LazyColumn(horizontalAlignment=Alignment.CenterHorizontally,
			verticalArrangement=Arrangement.spacedBy(16.dp),
			modifier=Modifier.fillMaxWidth()){
			val shows=vm.cardsState.shows?:emptyList()
			if(vm.cardsState.shows!=null){
				items(items=shows,
					   key={show->show.id}){ show->
					Card(show,onClick={
						navControler.navigate("show/${show.id}")
					})
				}
			}else if (vm.cardsState.shows?.isEmpty() == true){
				item{
					MassageAboutError("Серялів немає",responseVM)
				}
			}else if(responseVM.responseState.error!=null){
				item{
					MassageAboutError(responseVM.responseState.error!!,responseVM)
				}
			}else{
				item{
					Text("Почекайте...")
				}
			}
			//Card(Show(1,"","English","Move",Rating(28.0),arrayOf("1","2","3"),"running","2026"))
		}
	}
}


