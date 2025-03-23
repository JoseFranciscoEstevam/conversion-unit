package com.example.unitconversion.components

import GetUnitTypeConversionViewModel.Companion.sizeList
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconversion.ui.theme.colorSizeOption
import kotlinx.coroutines.delay

@Composable
fun LazyRowSize(
    modifier: Modifier = Modifier,
    SizeOption: MutableState<String>,
    isSelectedOptionSize: MutableState<Boolean>,
    showDescription: MutableState<Boolean>,
    showSizeOption: MutableState<Boolean>,
    showFormula: MutableState<Boolean>,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    selectedConstantFrom: MutableState<String>,
    selectedConstantTo: MutableState<String>,
    novoamount: MutableState<String>,
    enterValue: MutableState<String>,
    convertido: MutableState<String>,
    unitResult: MutableState<String>,
    selectedNumber: MutableState<String>,
    showNumberResult: MutableState<String>,
    totalCasasDecimais: MutableState<String>,
    conversion: MutableState<String>,
    selectedUnidadeFrom: MutableState<String>,
    selectedUnidadeTo: MutableState<String>,
    resultShort: MutableState<String>,
    resultFull: MutableState<String>,
    firstUnitName: MutableState<String>,
    firstUnitConstant: MutableState<String>
) {
    val focusRequester = remember { FocusRequester() }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current
    val keyboardController = LocalSoftwareKeyboardController.current


    Column(
        modifier
            .fillMaxWidth()
            //.padding(top = 20.dp)
            //.verticalScroll(scroll)
            .background(Color.DarkGray),
        verticalArrangement = Arrangement.spacedBy(0.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = "Unit Conversion",
            color = Color.LightGray,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp),
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.Cursive
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            Modifier
                .fillMaxWidth()
                //.height(50.dp)
                .padding(5.dp)
                .background(Transparent),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Size Option",
                color = if (showSizeOption.value) Red else White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            LaunchedEffect(Unit) {
                delay(1500)
                showSizeOption.value = true
            }
            AnimatedVisibility(
                visible = showSizeOption.value,
                enter = slideIn(initialOffset = { IntOffset(200, 0) }),
                exit = slideOut(targetOffset = { IntOffset(200, 0) }),
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                    contentDescription = "Select",
                    tint = Color.Blue
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Transparent),
                    horizontalAlignment = Alignment.Start,

                    ) {
                    Text(
                        text = "select",
                        color = Color.Yellow,
                        modifier = Modifier
                            .padding(start = 25.dp)
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        Column(
            Modifier
                .fillMaxWidth()
                .background(Transparent),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
        ) {
//            DisposableEffect(key1 = SizeOption, effect = {
//                onDispose {
//                    focusManager.clearFocus()
//                }
//            })
            LazyRow(
                contentPadding = PaddingValues(5.dp)
            ) {
                items(sizeList) { item ->
                    Card(
                        modifier = Modifier
                            .padding(3.dp)
                            .height(30.dp)
                            .background(Transparent)
                            .padding(1.dp)
                            .focusRequester(focusRequester)
                            .border(
                                width = 1.dp,
                                color = Color.LightGray,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .selectable(
                                selected = SizeOption.value == item.sizeName,
                            ) {
                                SizeOption.value =
                                    if (SizeOption.value == item.sizeName) item.sizeName
                                    else (-1).toString()
                                isSelectedOptionSize.value = !isSelectedOptionSize.value
                                SizeOption.value = item.sizeName
                                Toast
                                    .makeText(
                                        context,
                                        "${SizeOption.value} : Select Unit Option From and To ",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()

                                showFormula.value = true
                                showSizeOption.value = false
                                showDescription.value = true
                                selectedUnitFrom.value = ""
                                selectedUnitTo.value = ""
                                selectedConstantFrom.value = ""
                                selectedConstantTo.value = ""
                                novoamount.value = ""
                                enterValue.value = ""
                                convertido.value = ""
                                unitResult.value = "Convertido"
                                selectedNumber.value = "0"
                                showNumberResult.value = "0"
                                totalCasasDecimais.value = "0"
                                conversion.value = ""
                                selectedUnidadeFrom.value = ""
                                selectedUnidadeTo.value = ""
                                resultShort.value = "0"
                                resultFull.value = "0"
                                firstUnitConstant.value = ""
                                firstUnitName.value = ""
                                keyboardController?.hide()
                                focusManager.clearFocus()
                            },
                        colors = CardDefaults.cardColors(
                            containerColor = if (SizeOption.value == item.sizeName)
                                colorSizeOption else Transparent
                        )
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(5.dp)
                                .background(Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = item.sizeName,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                                textAlign = TextAlign.Center,
                                color = White
                            )
                        }

                    }
                }
            }
        }
    }
}