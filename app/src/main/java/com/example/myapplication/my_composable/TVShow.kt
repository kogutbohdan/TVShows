package com.example.myapplication.my_composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import com.example.myapplication.my_packets.Show

@Composable
fun TVShow(modifier:Modifier,show: Show){

    val summary = HtmlCompat.fromHtml(show.summary, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()

    val scrollState= rememberScrollState()
    Column(modifier = modifier.fillMaxSize().verticalScroll(scrollState)) {
        CardsContent(show=show, modifier = Modifier.padding(20.dp))

        Text(
            text=summary,
            modifier = Modifier.padding(20.dp),
        )
    }
}