package com.example.myapplication.my_storege

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


private val Context.dataStorege by preferencesDataStore(
    name="settings"
)

class Storege(private val context: Context) {
    private val SORTING_TYPE= stringPreferencesKey("sorting_type")
    val sortingType: Flow<String> = context.dataStorege.data.map{ prefs->
        prefs[SORTING_TYPE] ?: "rating"
    }

    suspend fun setSortingType(value: String){
        context.dataStorege.edit {prefs ->
            prefs[SORTING_TYPE]=value
        }
    }
}