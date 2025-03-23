package com.example.unitconversion

import GetUnitTypeConversionViewModel
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.unitconversion.components.BoxSpinnerResult
import com.example.unitconversion.components.BoxWithSelectOption
import com.example.unitconversion.components.ButtonClear
import com.example.unitconversion.components.ConversionDescriptionFormula
import com.example.unitconversion.components.LazyRowSize
import com.example.unitconversion.components.OutlinedTextFieldConversion
import com.example.unitconversion.components.PerformConversion
import com.example.unitconversion.components.UnitOption
import com.example.unitconversion.ui.theme.UnitConversionTheme
import com.example.unitconversion.ui.theme.gray1
import com.example.unitconversion.ui.theme.gray2
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UnitConversionScreen(
    modifier: Modifier = Modifier
) {
    val SizeOption = remember { mutableStateOf("") }
    val isSelectedOptionSize = remember { mutableStateOf(false) }
    val showDescription = remember { mutableStateOf(false) }
    val showSizeOption = remember { mutableStateOf(false) }
    val showFormula = remember { mutableStateOf(false) }
    val selectedUnitFrom = remember { mutableStateOf("") }
    val selectedUnitTo = remember { mutableStateOf("") }
    val selectedConstantFrom = remember { mutableStateOf("") }
    val selectedConstantTo = remember { mutableStateOf("") }
    val novoamount = remember { mutableStateOf("") }
    val enterValue = remember { mutableStateOf("") }
    val convertido = remember { mutableStateOf("") }
    val unitResult = remember { mutableStateOf("Convertido") }
    val selectedNumber = remember { mutableStateOf("0") }
    val showNumberResult = remember { mutableStateOf("0") }
    val totalCasasDecimais = remember { mutableStateOf("0") }
    val conversion = remember { mutableStateOf("") }
    val selectedUnidadeFrom = remember { mutableStateOf("") }
    val selectedUnidadeTo = remember { mutableStateOf("") }
    val resultShort = remember { mutableStateOf("0") }
    val resultFull = remember { mutableStateOf("0") }
    val firstUnitName = remember { mutableStateOf("") }
    val firstUnitConstant = remember { mutableStateOf("") }
    val sheetState = rememberModalBottomSheetState()
    val context = LocalContext.current
    val isSelectedUnitFrom = remember { mutableStateOf(false) }
    val isSelectedUnitTo = remember { mutableStateOf(false) }
    val expanded = remember { mutableStateOf(false) }
    val isSizeOption = remember { mutableStateOf(false) }
    val result = remember { mutableStateOf("") }
    val conver = remember { mutableStateOf("") }

    val coroutineScope = rememberCoroutineScope()
    var showModalBottomSheet by remember { mutableStateOf(false) }

    Column(
        modifier
            .fillMaxSize()
            .background(DarkGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        LazyRowSize(
            modifier = Modifier,
            SizeOption = SizeOption,
            isSelectedOptionSize = isSelectedOptionSize,
            showDescription = showDescription,
            showSizeOption = showSizeOption,
            showFormula = showFormula,
            selectedUnitFrom = selectedUnitFrom,
            selectedUnitTo = selectedUnitTo,
            selectedConstantFrom = selectedConstantFrom,
            selectedConstantTo = selectedConstantTo,
            novoamount = novoamount,
            enterValue = enterValue,
            convertido = convertido,
            unitResult = unitResult,
            selectedNumber = selectedNumber,
            showNumberResult = showNumberResult,
            totalCasasDecimais = totalCasasDecimais,
            conversion = conversion,
            selectedUnidadeFrom = selectedUnidadeFrom,
            selectedUnidadeTo = selectedUnidadeTo,
            resultShort = resultShort,
            resultFull = resultFull,
            firstUnitName = firstUnitName,
            firstUnitConstant = firstUnitConstant
        )
        UnitOption(
            modifier = Modifier,
            unit = "Unit From",
            showDescription = showDescription
        )
        BoxWithSelectOption(
            modifier = Modifier,
            sheetState = sheetState,
            valued = selectedUnitFrom.value,
            onValueChanged = { selectedUnitFrom.value = it },
            text = "Select Option Unit From",
            unidadeFrom = selectedUnidadeFrom.value,
            onClick = {
                if (SizeOption.value.isNotEmpty()) {
                    isSelectedUnitFrom.value = false
                    //isSelectedOptionFrom.value = !isSelectedOptionFrom.value
                    showModalBottomSheet = true
                } else {
                    Toast.makeText(context, "Select Size Option", Toast.LENGTH_SHORT).show()
                }
            }
        )
        HorizontalDivider(thickness = 1.dp, color = Red)
        Spacer(modifier = Modifier.height(5.dp))
        HorizontalDivider(thickness = 1.dp, color = Red)
        Column(
            modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Transparent)
                .padding(start = 0.dp)
                .border(
                    width = 1.dp,
                    color = White,
                    shape = RoundedCornerShape(15.dp)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 0.dp)
                    .background(Transparent),
            ) {
                Row(
                    modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = "Formula",
                        color = if (showFormula.value) Red else White,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(81.dp)
                    .background(Transparent)
                //.verticalScroll(scroll)
            ) {
                AnimatedVisibility(
                    visible = showDescription.value,
                    enter = slideIn(initialOffset = { IntOffset(200, 0) }),
                    exit = slideOut(targetOffset = { IntOffset(-200, 0) })
                ) {
                    ConversionDescriptionFormula(
                        modifier = Modifier,
                        SizeOption = SizeOption,
                        selectedUnitFrom = selectedUnitFrom,
                        selectedUnitTo = selectedUnitTo,
                        enterValue = enterValue,
                        firstUnitName = firstUnitName,
                        firstUnitConstant = firstUnitConstant,
                        selectedConstantFrom = selectedConstantFrom,
                        selectedConstantTo = selectedConstantTo,
                        resultFull = resultFull
                    )
                }
            }
        }
        Spacer(modifier = Modifier.height(2.dp))
        UnitOption(
            modifier = Modifier,
            unit = "Unit To",
            showDescription = showDescription
        )
        BoxWithSelectOption(
            modifier = Modifier,
            sheetState = sheetState,
            valued = selectedUnitTo.value,
            onValueChanged = { selectedUnitTo.value = it },
            text = "Select Option Unit To",
            unidadeFrom = selectedUnidadeTo.value,
            onClick = {
                if (SizeOption.value.isNotEmpty()) {
                    isSelectedUnitFrom.value = true
                    //isSelectedOptionTo.value = !isSelectedOptionTo.value
                    showModalBottomSheet = true

                } else {

                    Toast.makeText(context, "Select Size Option", Toast.LENGTH_SHORT).show()
                }
            }
        )
        Spacer(modifier.height(5.dp))
        Row(
            modifier,
            horizontalArrangement = Arrangement.spacedBy(5.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ButtonClear(
                modifier = Modifier,
                gradient = Brush.horizontalGradient(listOf(gray1, gray2)),
                SizeOption = SizeOption,
                selectedUnitFrom = selectedUnitFrom,
                selectedUnitTo = selectedUnitTo,
                novoamount = novoamount,
                convertido = convertido,
                isSelectedUnitFrom = isSelectedUnitFrom,
                isSelectedUnitTo = isSelectedUnitTo,
                //isSelectedOptionFrom = isSelectedOptionFrom,
                //isSelectedOptionTo = isSelectedOptionTo,
                isSizeOption = isSizeOption,
                isSelectedOptionSize = isSelectedOptionSize,
                showNumberResult = showNumberResult,
                conversion = conversion,
                selectedNumber = selectedNumber,
                showSizeOption = showSizeOption,
                showDescription = showDescription,
                resultShort = resultShort,
                resultFull = resultFull,
                unitResult = unitResult,
                totalCasasDecimais = totalCasasDecimais
            )
            BoxSpinnerResult(
                modifier = Modifier,
                novoamount = novoamount,
                totalCasasDecimais = totalCasasDecimais,
                selectedNumber = selectedNumber,
                expanded = expanded,
                resultFull = resultFull,
                resultShort = resultShort
            )
        }
        Spacer(modifier.height(5.dp))
        HorizontalDivider(thickness = 1.dp, color = Red)
        Spacer(modifier = Modifier.height(0.dp))
        UnitOption(
            unit = "Value",
            showDescription = showDescription,
        )
        OutlinedTextFieldConversion(
            modifier = Modifier,
            novoamount = novoamount,
            convertido = convertido,
            unitResult = unitResult,
            isSelectedUnitFrom = isSelectedUnitFrom,
            selectedUnitFrom = selectedUnitFrom,
            selectedUnitTo = selectedUnitTo,
        )

        PerformConversion(
            totalCasasDecimais = totalCasasDecimais,
            novoamount = novoamount,
            selectedUnitFrom = selectedUnitFrom,
            selectedUnitTo = selectedUnitTo,
            SizeOption = SizeOption,
            convertido = convertido,
            unitResult = unitResult,
            result = result,
            selectedNumber = selectedNumber,
            conver = conver,
            enterValue = enterValue,
            resultFull = resultFull,
            resultShort = resultShort,
        )
        if (showModalBottomSheet) {
            ModalBottomSheet(
                onDismissRequest = { showModalBottomSheet = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .padding(
                        WindowInsets.navigationBars
                            .only(WindowInsetsSides.Horizontal)
                            .asPaddingValues()
                    ),
                sheetState = sheetState,
                shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
                containerColor = Gray,
                contentColor = MaterialTheme.colorScheme.onSurface,


                ) {
                Column(
                    modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        // make sure the contents of the sheet is always above the nav bar
                        .navigationBarsPadding()
                        // draw the contents above the soft keyboard
                        .imePadding()
                ) {
                    if (isSelectedUnitFrom.value == false) {
                        TextField(
                            value = selectedUnitFrom.value,
                            onValueChange = { newValue ->
                                selectedUnitFrom.value = newValue
                            },
                            modifier = Modifier
                                .fillMaxWidth(),

                            trailingIcon = {
                                IconButton(

                                    onClick = {
                                        selectedUnitFrom.value = ""
                                        if (selectedUnitFrom.value == "") {
                                            showModalBottomSheet = true
                                        }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close Icon",
                                        tint = Red,
                                    )
                                }
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null,
                                    tint = Red
                                )
                            },
                            label = { Text("Search or Select Unit") }

                        )
                    } else {
                        TextField(
                            value = selectedUnitTo.value,
                            onValueChange = { newValue ->
                                selectedUnitTo.value = newValue
                            },
                            modifier = Modifier
                                .fillMaxWidth(),
                            trailingIcon = {
                                IconButton(
                                    onClick = {

                                        selectedUnitTo.value = ""
                                        if (selectedUnitTo.value == "") {
                                            showModalBottomSheet = true
                                        }
                                    },
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = "Close Icon",
                                        tint = Red,
                                    )
                                }
                            },
                            leadingIcon = {
                                Icon(
                                    imageVector = Icons.Default.Search,
                                    contentDescription = null,
                                    tint = Red
                                )
                            },
                            label = { Text("Search or Select Unit") }
                        )
                    }

                    BottomSheetContent(
                        onItemClick = {
                            if (isSelectedUnitFrom.value == false) {
                                selectedUnitFrom.value = it
                            } else {
                                //isSelectedUnitFrom.value = false
                                selectedUnitTo.value = it

                            }

                            coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                                if (!sheetState.isVisible) {
                                    showModalBottomSheet = false
                                }
                            }
                        },
                        getUnitTypeConversionViewModel = GetUnitTypeConversionViewModel(),
                        SizeOption = SizeOption,
                        isSelectedUnitFrom = isSelectedUnitFrom,
                        selectedUnidadeFrom = selectedUnidadeFrom,
                        selectedUnidadeTo = selectedUnidadeTo,
                        selectedUnitFrom = selectedUnitFrom,
                        selectedUnitTo = selectedUnitTo,
                        firstUnitName = firstUnitName,
                        firstUnitConstant = firstUnitConstant,
                        selectedConstantFrom = selectedConstantFrom,
                        selectedConstantTo = selectedConstantTo,

                    )

                }

            }
        }
    }
}









@Preview(showBackground = true)
@Composable
fun UnitConversionScreenPreview() {
    UnitConversionTheme {
        UnitConversionScreen()
    }
}