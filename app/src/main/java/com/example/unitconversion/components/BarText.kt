package com.example.unitconversion.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BarTextLong(
    modifier: Modifier = Modifier,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "▲\n▒\n▒\n▒\n▒\n▼",
            color = Color.Companion.Blue,
            fontWeight = FontWeight.Companion.ExtraBold,
            textAlign = TextAlign.Companion.Center,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(start = 0.dp)

        )
    }
}
@Composable
fun BarTextMediun(
    modifier: Modifier = Modifier,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "▲\n▒\n▒\n▼",
            color = Color.Companion.Blue,
            fontSize = 14.sp,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier
                .padding(start = 5.dp)

        )
    }
}

@Composable
fun BarTextExtraLong(
    modifier: Modifier = Modifier,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "▲\n▒\n▒\n▒\n▒\n▒\n▒\n▼",
            color = Color.Companion.Blue,
            fontSize = 14.sp,
            fontWeight = FontWeight.Companion.ExtraBold,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier
                .padding(start = 0.dp)

        )
    }
}

@Composable
fun BarTextShort(
    modifier: Modifier = Modifier,) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.Companion.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "▲\n▒\n▼",
            color = Color.Companion.Black,
            fontSize = 12.sp,
            fontWeight = FontWeight.Companion.ExtraBold,
            textAlign = TextAlign.Companion.Center,
            modifier = Modifier
                .padding(start = 0.dp)

        )
    }
}