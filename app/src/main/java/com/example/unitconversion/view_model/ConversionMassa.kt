package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionMassa: ViewModel() {
    var Quilograma = "1.0"
    var Grama = "1000"
    var Miligrama = "1000000"
    var Micrograma = "1000000000"
    var Tonelada = "0.001"
    var ToneladaDescolamento = "9.842519685039370078740157480315e-4"
    var ToneladaCurta = "0.00110253583241455347298787210584"
    var stone = "0.15748031496062992125984251968504"
    var Libra = "2.205"
    var Onca = "35.274"


    var beginning_gty = ""
    var ending_gty = ""
    var beginning_unit_type = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal{
        return when(unitType) {
            "Quilograma" -> BigDecimal(Quilograma)
            "Grama" -> BigDecimal(Grama)
            "Miligrama" -> BigDecimal(Miligrama)
            "Micrograma" -> BigDecimal(Micrograma)
            "Tonelada" -> BigDecimal(Tonelada)
            "Tonelada Deslocamento" -> BigDecimal(ToneladaDescolamento)
            "Tonelada Curta" -> BigDecimal(ToneladaCurta)
            "stone" -> BigDecimal(stone)
            "Libra" -> BigDecimal(Libra)
            "Onça" -> BigDecimal(Onca)
            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String {
        if (beginning_gty == "0"){
            ending_gty = "0.0"
        } else {
            val beginning_gty = BigDecimal(beginning_gty)
            val beginning_unit_type = getUnitTypeConstant(beginning_unit_type)
            val ending_unit_type = getUnitTypeConstant(ending_unit_type)

            ending_gty = BigDecimal.ONE.divide(beginning_unit_type, MathContext.DECIMAL128)
                .multiply(beginning_gty, MathContext.DECIMAL128)
                .multiply(ending_unit_type, MathContext.DECIMAL128).toString()

        }
        return ending_gty
    }

    fun setbeginning_gty(beginning_gty: String) {
        this.beginning_gty = beginning_gty
    }

    fun setbeginning_unit_type(beginning_unit_type: String) {
        this.beginning_unit_type = beginning_unit_type
    }

    fun setending_unit_type(ending_unit_type: String) {
        this.ending_unit_type = ending_unit_type
    }

    fun setEnding_gty() {
        this.ending_gty = calculateEndingQty()
    }
}