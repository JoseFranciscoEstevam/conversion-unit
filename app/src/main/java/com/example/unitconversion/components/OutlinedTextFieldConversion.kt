package com.example.unitconversion.components

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconversion.ui.theme.UnitConversionTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OutlinedTextFieldConversion(
    modifier: Modifier = Modifier,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    novoamount: MutableState<String>,
    convertido: MutableState<String>,
    unitResult: MutableState<String>,
    isSelectedUnitFrom: MutableState<Boolean>,
//    totalCasasDecimais: MutableState<String>,
//    result: MutableState<String>,

) {
    val focusManager = LocalFocusManager.current

    val context = LocalContext.current
//    if (novoamount.value.isNotEmpty()) {
//        val amount = novoamount.value
//        convertido.value = (amount.toDouble() * 1.5).toString()
//    }
    Column(
        modifier
            .fillMaxWidth()
            .background(LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(
            modifier
                .fillMaxWidth()
                .height(110.dp)
                .background(DarkGray),
            verticalAlignment = Alignment.Top
        ){

            OutlinedTextField(
                value = novoamount.value,
                onValueChange = { novoamount.value = it },

                modifier = Modifier
                    .width(120.dp)

                    .height(70.dp)
                    //.focusRequester(FocusRequester())
                    .onFocusChanged {
                        if (selectedUnitFrom.value.isEmpty() && selectedUnitTo.value.isEmpty()) {
                            if (it.isFocused) {
                                focusManager.clearFocus()
                                Toast.makeText(
                                    context,
                                    "1Select Unit Option From and To",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                                if (selectedUnitFrom.value.isNotEmpty() && selectedUnitTo.value.isEmpty()) {
                                    if (it.isFocused) {
                                        focusManager.clearFocus()
                                        Toast.makeText(
                                            context,
                                            "2Select Unit Option From and To",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                }

                        if (selectedUnitFrom.value.isEmpty() && selectedUnitTo.value.isNotEmpty()) {
                            if (it.isFocused) {
                                focusManager.clearFocus()
                                Toast.makeText(
                                    context,
                                    "3Select Unit Option From and To",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                                if (selectedUnitFrom.value.isNotEmpty() && selectedUnitTo.value.isNotEmpty()) {
                                    if (it.isFocused) {
                                        focusManager.moveFocus(
                                            if (isSelectedUnitFrom.value)
                                                FocusDirection.Exit
                                            else
                                                FocusDirection.Exit
                                        )
                                    }
                                }


                    },

                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                ),
                //singleLine = true,
                label = { Text("Enter value",
                    color = if (novoamount.value.isNotEmpty()) Green else White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                    )
                )
                        },
                keyboardOptions =
                KeyboardOptions(keyboardType = KeyboardType.Decimal),
                shape = RoundedCornerShape(size = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    White,
                    focusedBorderColor = White,
                    unfocusedBorderColor = White,
                    focusedLeadingIconColor = White,
                    unfocusedLeadingIconColor = White,
                    focusedTrailingIconColor = White,
                    unfocusedTrailingIconColor = White,
                    focusedLabelColor = White,
                    unfocusedLabelColor = White,
                    focusedPlaceholderColor = White,
                )
            )
            Box(
                modifier = Modifier
                    .width(14.dp)
                    .height(70.dp)
                    .background(Transparent)
                    .padding(horizontal = 4.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ("="),
                    color = White,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier,
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center
                )
            }
            OutlinedTextField(
                value = convertido.value ,
                onValueChange = {
                    convertido.value = it
                },
                textStyle = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = White,
                ),
                label = { Text(
                    text = unitResult.value,
                    color = if (novoamount.value.isNotEmpty())Green else White,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold,
                )
                )
                     },

                shape = RoundedCornerShape(size = 10.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    White,
                    focusedBorderColor = White,
                    unfocusedBorderColor = White,
                    focusedLeadingIconColor = White,
                    unfocusedLeadingIconColor = White,
                    focusedTrailingIconColor = White,
                    unfocusedTrailingIconColor = White,
                    focusedLabelColor = White,
                    unfocusedLabelColor = White,
                    focusedPlaceholderColor = White,
                    unfocusedTextColor = White,
                    disabledBorderColor = White,
                    disabledLabelColor = White,
                    disabledTextColor = White,
                    disabledPlaceholderColor = White,
                    disabledLeadingIconColor = White,
                    disabledTrailingIconColor = White,
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    //.width(265.dp)
                    .focusable()
                    .height(70.dp)
                    .onFocusEvent {
                        if (it.isFocused) {
                            focusManager.clearFocus()
                        }
                    },
                enabled = false,
            )
//            Box(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .width(180.dp)
//                    .height(65.dp)
//                    .padding(top = 5.dp)
//                    .background(if (novoamount.value.isNotEmpty()) Gray else Transparent)
//                    .border(
//                        1.dp,
//                        if ((isSelectedUnitFrom.value)) Green else White,
//                        RoundedCornerShape(10.dp)
//                    ),
//                contentAlignment = Alignment.Center
//            ) {
//                Text(
//                    text = convertido.value,
//                    color = White,
//                    fontSize = 14.sp,
//                    textAlign = TextAlign.Start,
//                    fontWeight = FontWeight.ExtraBold,
//                    modifier = Modifier
//                        .align(Alignment.TopCenter)
//                        .padding(top = 8.dp)
//                )
//                Text(
//                    text = unitResult.value,
//                    color = White,
//                    fontSize = 14.sp,
//                    textAlign = TextAlign.Start,
//                    fontWeight = FontWeight.ExtraBold,
//                    modifier = Modifier
//                        .align(Alignment.BottomCenter)
//                        .padding(bottom = 8.dp)
//                )
//                Text(
//                    text = result.value,
//                    color = if ((isSelectedUnitFrom.value)) Green else White,
//                    fontSize = 12.sp,
//                    fontWeight = FontWeight.ExtraBold
//                )
            }
        //}
//        Row {
//            Text(
//                text = "result = ${convertido.value}",
//            )
//        }
//        Row {
//            Text(
//                text = "totalCasasDecimais = ${totalCasasDecimais.value}",
//            )
//        }

    }
}

@Preview(showBackground = true)
@Composable
fun OutlinedTextFieldConversionPreview() {
    UnitConversionTheme {
        OutlinedTextFieldConversion(
            selectedUnitTo = remember { mutableStateOf("") },
            selectedUnitFrom = remember { mutableStateOf("") },
            isSelectedUnitFrom = remember { mutableStateOf(false) },
//            totalCasasDecimais = remember { mutableStateOf("") },
//            result = remember { mutableStateOf("") },
            modifier = Modifier,
            convertido = remember { mutableStateOf("") },
            novoamount = remember { mutableStateOf("") },
            unitResult = remember { mutableStateOf("") }




            )
    }
}