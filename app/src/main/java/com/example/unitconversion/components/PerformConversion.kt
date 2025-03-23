package com.example.unitconversion.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.unitconversion.view_model.ConversionAngulo
import com.example.unitconversion.view_model.ConversionArea
import com.example.unitconversion.view_model.ConversionArmazenamento
import com.example.unitconversion.view_model.ConversionComprimento
import com.example.unitconversion.view_model.ConversionConsumo
import com.example.unitconversion.view_model.ConversionEnergiaMecanica
import com.example.unitconversion.view_model.ConversionFrequencia
import com.example.unitconversion.view_model.ConversionMassa
import com.example.unitconversion.view_model.ConversionPressao
import com.example.unitconversion.view_model.ConversionTemperatura
import com.example.unitconversion.view_model.ConversionTempo
import com.example.unitconversion.view_model.ConversionTransmissaoDados
import com.example.unitconversion.view_model.ConversionVelocidades
import com.example.unitconversion.view_model.ConversionVolume
import java.math.BigDecimal

@Composable
fun PerformConversion(
    modifier: Modifier = Modifier,
    SizeOption: MutableState<String>,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    novoamount: MutableState<String>,
    convertido: MutableState<String>,
    unitResult: MutableState<String>,
    enterValue: MutableState<String>,
    conver: MutableState<String>,
    result: MutableState<String>,
    totalCasasDecimais: MutableState<String>,
    selectedNumber: MutableState<String>,
    resultFull: MutableState<String>,
    resultShort: MutableState<String>
) {
    val beginning_gty: String
    val ending_gty: BigDecimal
    val beginning_unit_type: String
    val ending_unit_type: String
    val conversionArea = ConversionArea()
    val conversionAngulo = ConversionAngulo()
    val conversionArmazenamento = ConversionArmazenamento()
    val conversionComprimento = ConversionComprimento()
    val conversionEnergiaMecanica = ConversionEnergiaMecanica()
    val conversionConsumo = ConversionConsumo()
    val conversionFrequencia = ConversionFrequencia()
    val conversionMassa = ConversionMassa()
    val conversionPressao = ConversionPressao()
    val conversionTemperatura = ConversionTemperatura()
    val conversionTempo = ConversionTempo()
    val conversionTransmissaoDados = ConversionTransmissaoDados()
    val conversionVelocidades = ConversionVelocidades()
    val conversionVolume = ConversionVolume()



//    val decimalPartLength: Int
//    val integerPartLength: Int
//    val totalLength: Int
    val novoNumber = totalCasasDecimais.value
    if (novoamount.value.isNotEmpty()) {


        val amountUnidade = novoamount.value
        beginning_gty = amountUnidade
        beginning_unit_type = selectedUnitFrom.value
        ending_unit_type = selectedUnitTo.value
        when (SizeOption.value) {
            "Area" -> {
                conversionArea.setbeginning_gty(beginning_gty)
                conversionArea.setbeginning_unit_type(beginning_unit_type)
                conversionArea.setending_unit_type(ending_unit_type)
                conversionArea.setEnding_gty()
                ending_gty = BigDecimal(conversionArea.calculateEndingQty())
                conversionArea.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""

            }
            "Angulo" -> {
                conversionAngulo.setbeginning_gty(beginning_gty)
                conversionAngulo.setbeginning_unit_type(beginning_unit_type)
                conversionAngulo.setending_unit_type(ending_unit_type)
                conversionAngulo.setEnding_gty()
                ending_gty = BigDecimal(conversionAngulo.calculateEndingQty())
                conversionAngulo.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Armazenamento de Dados" -> {
                conversionArmazenamento.setbeginning_gty(beginning_gty)
                conversionArmazenamento.setbeginning_unit_type(beginning_unit_type)
                conversionArmazenamento.setending_unit_type(ending_unit_type)
                conversionArmazenamento.setEnding_gty()
                ending_gty = BigDecimal(conversionArmazenamento.calculateEndingQty())
                conversionArmazenamento.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Comprimento" ->{
                conversionComprimento.setbeginning_gty(beginning_gty)
                conversionComprimento.setbeginning_unit_type(beginning_unit_type)
                conversionComprimento.setending_unit_type(ending_unit_type)
                conversionComprimento.setEnding_gty()
                ending_gty = BigDecimal(conversionComprimento.calculateEndingQty())
                conversionComprimento.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Energia Mecanica" -> {
                conversionEnergiaMecanica.setbeginning_gty(beginning_gty)
                conversionEnergiaMecanica.setbeginning_unit_type(beginning_unit_type)
                conversionEnergiaMecanica.setending_unit_type(ending_unit_type)
                conversionEnergiaMecanica.setEnding_gty()
                ending_gty = BigDecimal(conversionEnergiaMecanica.calculateEndingQty())
                conversionEnergiaMecanica.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Consumo de Combustivel" -> {
                conversionConsumo.setbeginning_gty(beginning_gty)
                conversionConsumo.setbeginning_unit_type(beginning_unit_type)
                conversionConsumo.setending_unit_type(ending_unit_type)
                conversionConsumo.setEnding_gty()
                ending_gty = BigDecimal(conversionConsumo.calculateEndingQty())
                conversionConsumo.ending_qty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Frequência" -> {
                conversionFrequencia.setbeginning_gty(beginning_gty)
                conversionFrequencia.setbeginning_unit_type(beginning_unit_type)
                conversionFrequencia.setending_unit_type(ending_unit_type)
                conversionFrequencia.setEnding_gty()
                ending_gty = BigDecimal(conversionFrequencia.calculateEndingQty())
                conversionFrequencia.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Massa" -> {
                conversionMassa.setbeginning_gty(beginning_gty)
                conversionMassa.setbeginning_unit_type(beginning_unit_type)
                conversionMassa.setending_unit_type(ending_unit_type)
                conversionMassa.setEnding_gty()
                ending_gty = BigDecimal(conversionMassa.calculateEndingQty())
                conversionMassa.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Pressão" -> {
                conversionPressao.setbeginning_gty(beginning_gty)
                conversionPressao.setbeginning_unit_type(beginning_unit_type)
                conversionPressao.setending_unit_type(ending_unit_type)
                conversionPressao.setEnding_gty()
                ending_gty = BigDecimal(conversionPressao.calculateEndingQty())
                conversionPressao.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Temperatura" -> {
                conversionTemperatura.setbeginning_gty(beginning_gty)
                conversionTemperatura.setbeginning_unit_type(beginning_unit_type)
                conversionTemperatura.setending_unit_type(ending_unit_type)
                conversionTemperatura.setEnding_gty()
                ending_gty = BigDecimal(conversionTemperatura.calculateEndingQty())
                conversionTemperatura.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Tempo" -> {
                conversionTempo.setbeginning_gty(beginning_gty)
                conversionTempo.setbeginning_unit_type(beginning_unit_type)
                conversionTempo.setending_unit_type(ending_unit_type)
                conversionTempo.setEnding_gty()
                ending_gty = BigDecimal(conversionTempo.calculateEndingQty())
                conversionTempo.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Transmissão de Dados" -> {
                conversionTransmissaoDados.setbeginning_gty(beginning_gty)
                conversionTransmissaoDados.setbeginning_unit_type(beginning_unit_type)
                conversionTransmissaoDados.setending_unit_type(ending_unit_type)
                conversionTransmissaoDados.setEnding_gty()
                ending_gty = BigDecimal(conversionTransmissaoDados.calculateEndingQty())
                conversionTransmissaoDados.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Velocidade" -> {
                conversionVelocidades.setbeginning_gty(beginning_gty)
                conversionVelocidades.setbeginning_unit_type(beginning_unit_type)
                conversionVelocidades.setending_unit_type(ending_unit_type)
                conversionVelocidades.setEnding_gty()
                ending_gty = BigDecimal(conversionVelocidades.calculateEndingQty())
                conversionVelocidades.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()
                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
            "Volume" -> {
                conversionVolume.setbeginning_gty(beginning_gty)
                conversionVolume.setbeginning_unit_type(beginning_unit_type)
                conversionVolume.setending_unit_type(ending_unit_type)
                conversionVolume.setEnding_gty()
                ending_gty = BigDecimal(conversionVolume.calculateEndingQty())
                conversionVolume.ending_gty
                enterValue.value = amountUnidade
                convertido.value = ending_gty.toPlainString()

                resultFull.value = convertido.value
                resultShort.value = convertido.value
                FormatDecimalPlaces(
                    convertido,
                    resultFull,
                    resultShort,
                    totalCasasDecimais,
                    selectedNumber
                )
                conver.value = (ending_gty.stripTrailingZeros() - ending_gty.stripTrailingZeros())
                    .stripTrailingZeros()
                    .toString()
                unitResult.value = ending_unit_type
                result.value = ""
            }
        }
        if (novoNumber != totalCasasDecimais.value) {
            selectedNumber.value = totalCasasDecimais.value
        }
    } else {
        enterValue.value = ""
        convertido.value = ""
        resultFull.value = ""
        resultShort.value = ""
        conver.value = ""
        totalCasasDecimais.value = "0"
        selectedNumber.value = "0"
        unitResult.value = "convertido"
        result.value = ""

    }
}