package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext
import kotlin.math.PI

class ConversionAngulo: ViewModel() {
    var angular = 1000 * PI / 180
    var radianos = PI / 180
    var Grau = "1.0"
    var Grado = "1.1111111111111112"
    var Mil_Angular = angular.toString()
    var Minuto_de_Arco = "60.0"
    var Radiano = radianos.toString()
    var Segundo_de_Arco = "3600.0"

    private var beginning_gty = "0.0"
    var ending_gty = ""
    private var beginning_unit_type = ""
    private var ending_unit_type = ""

    fun setbeginning_unit_type(beginning_unit_type: String) {
        this.beginning_unit_type = beginning_unit_type
    }

    fun setending_unit_type(ending_unit_type: String) {
        this.ending_unit_type = ending_unit_type
    }
    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Grado" -> BigDecimal(Grado)
            "Grau" -> BigDecimal(Grau)
            "Mil Angular" -> BigDecimal(Mil_Angular)
            "Minuto de Arco" -> BigDecimal(Minuto_de_Arco)
            "Radiano" -> BigDecimal(Radiano)
            "Segundo de Arco" -> BigDecimal(Segundo_de_Arco)
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

            val ending_gty = BigDecimal.ONE.divide(beginning_unit_type, MathContext.DECIMAL128)
                .multiply(ending_unit_type, MathContext.DECIMAL128)
                .multiply(beginning_gty, MathContext.DECIMAL128)

            return ending_gty.toString()
        }
        return ending_gty
    }

    fun setbeginning_gty(beginningGty: String) {
        this.beginning_gty = beginningGty
    }

    fun setEnding_gty() {
        this.ending_gty = calculateEndingQty()
    }
}