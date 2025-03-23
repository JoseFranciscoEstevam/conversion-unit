package com.example.unitconversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ButtonClear(
    modifier: Modifier = Modifier,
    gradient: Brush,
    SizeOption: MutableState<String>,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    novoamount: MutableState<String>,
    convertido: MutableState<String>,
    isSelectedUnitFrom: MutableState<Boolean>,
    isSelectedUnitTo: MutableState<Boolean>,
    isSizeOption: MutableState<Boolean>,
    isSelectedOptionSize: MutableState<Boolean>,
    showNumberResult: MutableState<String>,
    conversion: MutableState<String>,
    selectedNumber: MutableState<String>,
    showSizeOption: MutableState<Boolean>,
    showDescription: MutableState<Boolean>,
    resultShort: MutableState<String>,
    resultFull: MutableState<String>,
    unitResult: MutableState<String>,
    totalCasasDecimais: MutableState<String>
    ) {


    val keyboardController = LocalSoftwareKeyboardController.current

    val focusManager = LocalFocusManager.current

    Button(
        modifier = Modifier
            //.fillMaxWidth()
            .border(1.dp, color = White, RoundedCornerShape(10.dp))
            .height(100.dp)
            .background(gradient)
            .width(100.dp),

        colors = ButtonDefaults.buttonColors(
            containerColor = Transparent,
        ),
        onClick = {
            showDescription.value = false
            showSizeOption.value = true
            SizeOption.value = ""
            selectedUnitFrom.value = ""
            selectedUnitTo.value = ""
            novoamount.value = ""
            convertido.value = ""
            isSelectedUnitFrom.value = false
            isSelectedUnitTo.value = false
            showNumberResult.value = ""
            conversion.value = ""
            selectedNumber.value = "0"
            isSizeOption.value = false
            isSelectedOptionSize.value = false
            resultShort.value = "0"
            resultFull.value = "0"
            keyboardController?.hide()
            focusManager.clearFocus()
            unitResult.value = "Convertido"
            totalCasasDecimais.value = "0"

        },
    ) {
        Text(
            text = "Clear",
            fontSize = 16.sp,
            color = White,
            modifier = Modifier

        )
    }
}