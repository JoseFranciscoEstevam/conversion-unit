package com.example.unitconversion.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UnitOption(
    modifier: Modifier = Modifier,
    unit: String,
    showDescription: MutableState<Boolean>,
) {
    Row(
        modifier
            .fillMaxWidth()
            //.height(50.dp)
            //.padding(5.dp)
            .background(Transparent)
    ){
        Text(
            text = unit,
            color = if (showDescription.value) Red else White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        AnimatedVisibility(
            visible = showDescription.value,
            enter = slideIn(initialOffset = { IntOffset(200, 0) }),
            exit = slideOut(targetOffset = { IntOffset(200, 0) })
        ) {
            if (showDescription.value) {
                LaunchedEffect(Unit) {
                    //delay(2000)
                    showDescription.value = true
                }
            }
            Icon(
                tint = Color.Blue,
                imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                contentDescription = "",
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Transparent),
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "select",
                    color = Yellow,
                    modifier = Modifier
                        .padding(start = 25.dp)
                    )
            }
        }
    }
}