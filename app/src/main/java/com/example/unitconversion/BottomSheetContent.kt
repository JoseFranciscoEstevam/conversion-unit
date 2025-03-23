package com.example.unitconversion

import GetUnitTypeConversionViewModel
import GetUnitTypeConversionViewModel.UnitList
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BottomSheetContent(
    modifier: Modifier = Modifier,
    onItemClick: (String) -> Unit,
    getUnitTypeConversionViewModel: GetUnitTypeConversionViewModel,
    SizeOption: MutableState<String>,
    isSelectedUnitFrom: MutableState<Boolean>,
    selectedUnidadeFrom: MutableState<String>,
    selectedUnidadeTo: MutableState<String>,
    selectedUnitFrom: MutableState<String>,
    selectedUnitTo: MutableState<String>,
    firstUnitName: MutableState<String>,
    firstUnitConstant: MutableState<String>,
    selectedConstantFrom: MutableState<String>,
    selectedConstantTo: MutableState<String>,

    ) {
    val unities = remember { mutableStateOf(listOf<UnitList>()) }
    val regex = Regex(".*[0-9].*")
//    val unitArea = getUnitTypeConversion.getUnitArea()
//    var unities = unitArea
//    val unitAngulo = getUnitTypeConversionViewModel.getUnitAngulo()


    when (SizeOption.value) {
        "Area" -> unities.value = getUnitTypeConversionViewModel.getUnitArea()
    }
    when (SizeOption.value) {
        "Angulo" -> unities.value = getUnitTypeConversionViewModel.getUnitAngulo()
        }
    when (SizeOption.value) {
        "Armazenamento de Dados" -> unities.value =
            getUnitTypeConversionViewModel.getUnitArmazenamento()
    }
    when (SizeOption.value) {
        "Comprimento" -> unities.value = getUnitTypeConversionViewModel.getUnitComprimento()
    }
    when (SizeOption.value) {
        "Energia Mecanica" -> unities.value =
            getUnitTypeConversionViewModel.getUnitEnergiaMecanica()
    }
    when (SizeOption.value) {
        "Consumo de Combustivel" -> unities.value = getUnitTypeConversionViewModel.getUnitConsumo()
    }
    when (SizeOption.value) {
        "Frequência" -> unities.value = getUnitTypeConversionViewModel.getUnitFrequencia()
    }
    when (SizeOption.value) {
        "Massa" -> unities.value = getUnitTypeConversionViewModel.getUnitMassa()
    }
    when (SizeOption.value) {
        "Pressão" -> unities.value = getUnitTypeConversionViewModel.getUnitPressao()
    }
    when (SizeOption.value) {
        "Temperatura" -> unities.value = getUnitTypeConversionViewModel.getUnitTemperatura()
    }
    when (SizeOption.value) {
        "Tempo" -> unities.value = getUnitTypeConversionViewModel.getUnitTempo()
    }
    when (SizeOption.value) {
        "Transmissão de Dados" -> unities.value = getUnitTypeConversionViewModel.getUnitTransmissaoDados()
    }
    when (SizeOption.value) {
        "Velocidade" -> unities.value = getUnitTypeConversionViewModel.getUnitVelocidade()
    }
    when (SizeOption.value) {
        "Volume" -> unities.value = getUnitTypeConversionViewModel.getUnitVolume()
    }


    Column(
        modifier
            .fillMaxSize()
            .height(300.dp)
            .padding(5.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth(),
            contentPadding = PaddingValues(16.dp),
            //verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(unities.value) {
                firstUnitConstant.value = unities.value.first().unitConstant.toString()
                firstUnitName.value = unities.value.first().unitName
                if (it.unitName.contains(
                       if (isSelectedUnitFrom.value == false)
                           selectedUnitFrom.value else
                               selectedUnitTo.value,
                        regex.containsMatchIn(it.unitName)
                  )
               ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "${it.unitName} : ${it.unitUnidade}",
                            modifier = Modifier
                                .fillMaxWidth()

                                .clickable {
                                    if (isSelectedUnitFrom.value == false) {
                                        onItemClick(it.unitName)
                                        selectedUnidadeFrom.value = it.unitUnidade
                                        selectedConstantFrom.value = it.unitConstant.toString()
                                    } else {
                                        onItemClick(it.unitName)
                                        selectedUnidadeTo.value = it.unitUnidade
                                        selectedConstantTo.value = it.unitConstant.toString()
                                    }


                                }
                        )
                    }


                }
            }
        }
    }
}
