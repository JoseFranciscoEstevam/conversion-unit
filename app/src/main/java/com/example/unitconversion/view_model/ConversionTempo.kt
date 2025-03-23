package com.example.unitconversion.view_model

import java.math.BigDecimal
import java.math.MathContext

class ConversionTempo {
    var Nanosegundo = 1.0
    var Microssegundo = 0.001
    var Milissegundo = 0.000001
    var Segundo = 0.000000001
    var Minuto = 1.6666666666666666666666666666667e-11
    var Hora = 2.7777777777777777777777777777778e-13
    var Dia = 1.1574074074074074074074074074074e-14
    var Semana = 1.6534391534391534391534391534392e-15
    var Mes = 3.805175038051750380517503805175e-16
    var AnoCalendario = 3.1705770450221940393151553582752e-17
    var Decada = 3.1705770450221940393151553582752e-18
    var Seculo = 3.1705770450221940393151553582752e-19
    var Milenio = 3.1705770450221940393151553582752e-20


    var beginning_gty = ""
    var ending_gty = ""
    var beginning_unit_type = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Nanosegundo" -> BigDecimal(Nanosegundo)
            "Microssegundo" -> BigDecimal(Microssegundo)
            "Milissegundo" -> BigDecimal(Milissegundo)
            "Segundo" -> BigDecimal(Segundo)
            "Minuto" -> BigDecimal(Minuto)
            "Hora" -> BigDecimal(Hora)
            "Dia" -> BigDecimal(Dia)
            "Semana" -> BigDecimal(Semana)
            "Mes" -> BigDecimal(Mes)
            "Ano Calendario" -> BigDecimal(AnoCalendario)
            "Decada" -> BigDecimal(Decada)
            "Seculo" -> BigDecimal(Seculo)
            "Milenio" -> BigDecimal(Milenio)
            else -> BigDecimal.ONE
        }
    }

    fun calculateEndingQty(): String {
        if (beginning_gty == "0") {
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

