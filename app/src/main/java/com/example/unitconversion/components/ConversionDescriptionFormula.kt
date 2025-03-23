package com.example.unitconversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ConversionDescriptionFormula(
    modifier: Modifier = Modifier,
    SizeOption: MutableState<String>,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    enterValue: MutableState<String>,
    firstUnitName: MutableState<String>,
    firstUnitConstant: MutableState<String>,
    selectedConstantFrom: MutableState<String>,
    selectedConstantTo: MutableState<String>,
    resultFull: MutableState<String>

) {
    val scroll = rememberScrollState()
    Row(
        modifier
            .fillMaxWidth()
            .height(81.dp)
            .background(Color.DarkGray),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        if (firstUnitConstant.value.isNotEmpty()) {


            Box(
                modifier = Modifier
                    .width(30.dp)
                    .height(80.dp)
                    .verticalScroll(scroll)
                    .background(Transparent),
                contentAlignment = Alignment.Center
            ) {
                // Substitua BarTextShort() pelo seu Composable correspondente
//            if (firstUnitConstant.value.isNotEmpty()) {
                BarTextMediun()
//            }
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .padding(end = 5.dp)
                .verticalScroll(scroll)
                .background(Transparent),
            contentAlignment = Alignment.Center
        ) {
            val conversionText = when (SizeOption.value) {
                "Temperatura" -> {
                    when {
//                        selectedUnitFrom.value == "Grau Celsius" && selectedUnitTo.value == "Grau Celsius" ->
//                            "Conversion ${SizeOption.value} = (Grau Celsius => The Value = ${enterValue} ) => Result = ${conversion.value} ${selectedUnitTo.value}"
                        selectedUnitFrom.value == "Grau Celsius" && selectedUnitTo.value == "Grau Fahrenheit" ->
                            "Conversion ${SizeOption.value} = ((Grau Celsius = The Value = (${enterValue.value} * 9.0 / 5.0) + 32)  => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        selectedUnitFrom.value == "Grau Celsius" && selectedUnitTo.value == "Grau Kelvin" ->
                            "Conversion ${SizeOption.value} = (Grau Celsius => The Value = ${enterValue.value} + 273.15) => Result = ${resultFull.value} ${selectedUnitTo.value}"
//                        selectedUnitFrom.value == "Grau Fahrenheit" && selectedUnitTo.value == "Grau Fahrenheit" ->
//                            "ConversionF ${SizeOption.value} = (Grau Fahrenheit => The Value = ${enterValue.value} ) => Result = ${conversion.value} ${selectedUnitTo.value}"
                        selectedUnitFrom.value == "Grau Fahrenheit" && selectedUnitTo.value == "Grau Celsius" ->
                            "Conversion ${SizeOption.value} = ((Grau Fahrenheit => The Value = ${enterValue.value} -32) * 5.0 / 9.0)) => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        selectedUnitFrom.value == "Grau Fahrenheit" && selectedUnitTo.value == "Grau Kelvin" ->
                            "Conversion ${SizeOption.value} = ((Grau Celsius => The Value = ${enterValue.value} - 32) * 5.0 / 9.0 + 273.15) => Result = ${resultFull.value} ${selectedUnitTo.value}"
//                        selectedUnitFrom.value == "Grau Kelvin" && selectedUnitTo.value == "Grau Kelvin" ->
//                            "Conversion ${SizeOption.value} = (Grau Kelvin => The Value = ${enterValue.value} ) => Result = ${conversion.value} ${selectedUnitTo.value}"
                        selectedUnitFrom.value == "Grau Kelvin" && selectedUnitTo.value == "Grau Celsius" ->
                            "Conversion ${SizeOption.value} = (Grau Kelvin => The Value = ${enterValue.value} - 273.15)  => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        selectedUnitFrom.value == "Grau Kelvin" && selectedUnitTo.value == "Grau Fahrenheit" ->
                            "Conversion ${SizeOption.value} = ((Grau Kelvin => The Value = ${enterValue.value} - 273.15) * 9.0 / 5.0 + 32) => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        else -> "Conversion ${SizeOption.value} = (${firstUnitName.value} = ${firstUnitConstant.value})  /  " +
                                "Constant de  (${selectedUnitFrom.value} = ${selectedConstantFrom.value})  " +
                                "* Constant de (${selectedUnitTo.value} = ${selectedConstantTo.value})  *  " +
                                "The Value = ${enterValue.value} => Result = ${resultFull.value}  ${selectedUnitTo.value}"
                    }
                }

                "Consumo de Combustivel" -> {
                    when {
                        selectedUnitFrom.value == "Kilometro por Litro" && selectedUnitTo.value == "Litro por 100 Kilometros" ->
                            "Conversion ${SizeOption.value} = 100 / The Value = ${enterValue.value} => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        selectedUnitFrom.value == "Milha por Galão Americano" && selectedUnitTo.value == "Litro por 100 Kilometros" ->
                            "Conversion ${SizeOption.value} = 235.215 / The Value = ${enterValue.value} => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        selectedUnitFrom.value == "Milha por Galão Imperial" && selectedUnitTo.value == "Litro por 100 Kilometros" ->
                            "Conversion ${SizeOption.value} = 282.481 / The Value = ${enterValue.value} => Result = ${resultFull.value} ${selectedUnitTo.value}"

                        else -> "Conversion ${SizeOption.value} = (${firstUnitName.value} = ${firstUnitConstant.value})  /  " +
                                "Constant de  (${selectedUnitFrom.value} = ${selectedConstantFrom.value})  " +
                                "* Constant de (${selectedUnitTo.value} = ${selectedConstantTo.value})  *  " +
                                "The Value = ${enterValue.value} => Result = ${resultFull.value}  ${selectedUnitTo.value}"
                    }
                }

                else -> "Conversion ${SizeOption.value} = (${firstUnitName.value} = ${firstUnitConstant.value})  /  Constant de =>(${selectedUnitFrom.value} = ${selectedConstantFrom.value}) * Constant de =>(${selectedUnitTo.value} = ${selectedConstantTo.value})  *  The Value = ${enterValue.value}  -> Result = ${resultFull.value}  ${selectedUnitTo.value}"
            }
            Text(
                text = conversionText,
                color = White,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                modifier = Modifier
                    .padding(start = 10.dp, end = 10.dp)
            )
        }
    }
}