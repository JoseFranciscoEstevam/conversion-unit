package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionPressao: ViewModel() {

    var AtmosferaPadrao = "1.0"
    var Bar = "1.01325"
    var Pascal = "101325.0"
    var Psi = "14.6959"
    var Torr = "760.0"

    var beginning_gty = ""
    var ending_gty = ""
    var beginning_unit_type = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal{
        return when (unitType) {
            "Atmosfera Padrão" -> BigDecimal(AtmosferaPadrao)
            "Bar" -> BigDecimal(Bar)
            "Pascal" -> BigDecimal(Pascal)
            "Psi" -> BigDecimal(Psi)
            "Torr" -> BigDecimal(Torr)
            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String {
        if (beginning_gty == "0.0"){
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