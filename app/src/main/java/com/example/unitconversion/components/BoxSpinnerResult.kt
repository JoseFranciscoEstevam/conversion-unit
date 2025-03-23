package com.example.unitconversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BoxSpinnerResult(
    modifier: Modifier = Modifier,
    expanded: MutableState<Boolean>,
    selectedNumber: MutableState<String>,
    resultShort: MutableState<String>,
    totalCasasDecimais: MutableState<String>,
    resultFull: MutableState<String>,
    novoamount: MutableState<String>,

    ) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val number = totalCasasDecimais.value
    Column {
        Box(
            modifier
                //.fillMaxWidth()
                .border(1.dp, color = White, RoundedCornerShape(10))
                .height(100.dp)
                .background(DarkGray)
                .clickable {
                    //expanded.value = if (conversion.isEmpty()) true else false
                    expanded.value = !expanded.value
                },
            contentAlignment = Alignment.Center
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .height(100.dp)
                    .background(Transparent),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Transparent),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Total Casas Decimais = ${totalCasasDecimais.value}",
                        fontWeight = FontWeight.ExtraBold,
                        color = White
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(20.dp)
                        .background(Color.LightGray),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Select = ${selectedNumber.value}",
                        fontWeight = FontWeight.ExtraBold,
                        color = Black
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        tint = Red,
                        modifier = Modifier
                            .padding(start = 20.dp)
                            .rotate(if (expanded.value) 180f else 0f)
                            .border(
                                1.dp,
                                color = White,
                                RoundedCornerShape(3)
                            )
                    )
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(95.dp)
                        .background(Transparent),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    if (resultFull.value.length > 19) {
                        Box(
                            modifier = Modifier
                                .width(30.dp)
                                .height(95.dp)
                                .verticalScroll(rememberScrollState())
                                .background(Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            BarTextLong()
                        }
                    }
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .padding(start = 5.dp)
                            .verticalScroll(rememberScrollState())
                            .background(Transparent),
                        contentAlignment = Alignment.Center
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "Result = ${resultShort.value}",
                                color = White,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier
                                //.align(Alignment.Start)
                            )
                            Text(
                                text = "Result Full = ${resultFull.value}",
                                //text = "Cover = $conver",
                                color = White,
                                fontWeight = FontWeight.ExtraBold,
                                modifier = Modifier
                                //.align(Alignment.Start)
                            )
                        }
                    }
                    if (novoamount.value.isNotEmpty()) {
                        DropdownMenu(
                            expanded = expanded.value,
                            onDismissRequest = { expanded.value = false }
                        ) {
                            for (listNumber in 0..number.toInt()) {
                                //val numberLast = listNumber.toString().last()
                                DropdownMenuItem(
                                    modifier = Modifier
                                        .padding(0.dp)
                                        .background(Color.LightGray),
                                    text = {
                                        Text(
                                            text = "$listNumber",
                                            textAlign = TextAlign.End,
                                            color = Black,
                                            fontSize = 20.sp
                                        )
                                    },
                                    onClick = {
                                        selectedNumber.value = listNumber.toString()
                                        expanded.value = false
                                        //focusManager.clearFocus()
                                        keyboardController?.hide()
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}