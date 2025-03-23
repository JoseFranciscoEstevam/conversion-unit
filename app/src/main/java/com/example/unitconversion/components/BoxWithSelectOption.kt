package com.example.unitconversion.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BoxWithSelectOption(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    sheetState: SheetState,
    valued: String,
    onValueChanged: (String) -> Unit,
    text: String,
    unidadeFrom: String,

) {
    val focusManager = LocalFocusManager.current
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGray),
        horizontalArrangement = Arrangement.SpaceAround

    ) {
        OutlinedTextField(
            value = valued,
            onValueChange = onValueChanged,
            modifier
                .fillMaxWidth()
                .weight(0.5f)

                .onFocusChanged {
                    if (it.isFocused) {
                        onClick()
                        focusManager.clearFocus()
                    }
                },

            label = {
                Text(
                    text = text,
                    color = if(
                        valued.isNotEmpty()
                    ) Green else White,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                )
            },
            textStyle = TextStyle(
                color = White,
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = White,
                unfocusedBorderColor = White,
                unfocusedTextColor = White,
                focusedTextColor = White
            ),
            shape = RoundedCornerShape(15.dp),
            suffix = {
                Text(
                    text = unidadeFrom,
                    color = White,
                    fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier
                        .padding(end = 20.dp)
                )
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null,
                    tint = Red,
                    modifier = Modifier
                        .padding(end = 20.dp)
                        .size(50.dp)
                        //.align(Alignment.CenterEnd)
                        .rotate(if (sheetState.isVisible) 180f else 0f)
                )
            }
        )

    }
}