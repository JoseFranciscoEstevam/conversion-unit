package com.example.unitconversion.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import java.math.BigDecimal
import kotlin.math.abs

@Composable
fun FormatDecimalPlaces(
    convertido: MutableState<String>,
    resultFull: MutableState<String>,
    resultShort: MutableState<String>,
    totalCasasDecimais: MutableState<String>,
    selectedNumber: MutableState<String>
) {
    if (convertido.value.endsWith("0") || convertido.value.contains(".")) {
        val regex = Regex("(\\.[0-9]+?)0+$") // Regex corrigida
        val convertidoRegex1 = regex.replace(convertido.value) { matchResult ->
            val decimalPart = matchResult.groupValues[1]
            if (decimalPart.isEmpty()) {
                "00"
            } else {
                decimalPart + "0"
            }
        }
        convertido.value = convertidoRegex1
        resultFull.value = convertido.value
    }
    val isInteger = isInteger(BigDecimal(convertido.value))

    val decimalPartLength: Int
    val integerPartLength: Int
    val totalLength: Int

    if (isInteger) {
        decimalPartLength = 0
        integerPartLength = convertido.value.length
        totalLength = integerPartLength
    } else {
        val numberString = resultFull.value.trimEnd('0')
        val parts = numberString.split(".")
        decimalPartLength = parts[1].length
        integerPartLength = parts[0].length
        totalLength = integerPartLength + decimalPartLength
    }
    if (totalLength > 18){
        val coefficient = (18 - integerPartLength).toString()
        convertido.value = BigDecimal(convertido.value)
            .setScale(
                abs( coefficient.toInt()),
                BigDecimal.ROUND_HALF_UP).toPlainString()

        if (convertido.value.endsWith("0") || convertido.value.contains(".")) {
            val regex = Regex("(\\.[0-9]+?)0+$") // Regex corrigida
            val convertidoRegex1 = regex.replace(convertido.value) { matchResult ->
                val decimalPart = matchResult.groupValues[1]
                if (decimalPart.isEmpty()) {
                    "00"
                } else {
                    decimalPart + "0"
                }
            }
            convertido.value = convertidoRegex1
            //resultFull.value = convertido.value
        }
    }
    if (selectedNumber.value > 0.toString()){
        resultShort.value = BigDecimal(resultFull.value)
            .setScale(
                selectedNumber.value.toInt(),
                BigDecimal.ROUND_HALF_UP).toPlainString()
    }else {
        resultShort.value = resultFull.value
    }
    totalCasasDecimais.value = decimalPartLength.toString()

}
fun isInteger(number: BigDecimal): Boolean {
    return number.compareTo(BigDecimal(number.toBigInteger())) == 0
}
