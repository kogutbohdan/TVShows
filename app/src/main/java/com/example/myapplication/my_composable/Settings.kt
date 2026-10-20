package com.example.myapplication.my_composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.view_models.SettingsViewModel

@Composable
fun Settings(modifier: Modifier= Modifier,vm: SettingsViewModel = viewModel()){
    val  options = listOf(
        "rating" to "Highest rated first",
        "date" to "Newest first",
        "date_old" to "Oldest first",
        "title" to "Title (A–Z)"
    )
    Column (modifier=modifier) {
        for(option in options){
            Row(
                modifier = Modifier.padding(20.dp).fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = vm.sortingType == option.first,
                    onClick = {
                        vm.changeSortingType(value = option.first)
                    },
                )
                Text(option.second)
            }
        }
    }
}