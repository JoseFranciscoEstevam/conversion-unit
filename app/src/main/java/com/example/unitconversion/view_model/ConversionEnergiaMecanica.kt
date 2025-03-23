package com.example.unitconversion.view_model

import androidx.compose.ui.unit.TextUnitType
import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionEnergiaMecanica: ViewModel() {

    var joule = "1.0"
    var Quilojoule = "0.001"
    var GramCalorie = "0.239005736137667304015"
    var Quilocaloria = "0.000239005736137667304"
    var WattHora = "0.000277777777777777777"
    var QuiloWattHora = "2.7777777777777777777e-7"
    var EletronVolt = "6.242e+18"
    var BTU = "9.4786729857819905213270142180095e-4"
    var thermUSA = "9.4786729857819905213270142180095e-9"
    var PelibraForca = "0.73746312684365781710914454277286"

    var beginning_gty: String = ""
    var ending_gty: String = ""
     var beginning_unit_type = ""
     var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal{
        return when(unitType){
            "Joule" -> BigDecimal(joule)
            "Kilojoule" -> BigDecimal(Quilojoule)
            "Gram Calorie" -> BigDecimal(GramCalorie)
            "Kilocalorie" -> BigDecimal(Quilocaloria)
            "Watt-Hora" -> BigDecimal(WattHora)
            "KiloWatt-Hora" -> BigDecimal(QuiloWattHora)
            "Eletron-Volt" -> BigDecimal(EletronVolt)
            "British Thermal Unit" -> BigDecimal(BTU)
            "therm(US)" -> BigDecimal(thermUSA)
            "Pé-libra Força" -> BigDecimal(PelibraForca)
            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String{
        if (beginning_gty == "0"){
            ending_gty = "0.0"
        } else {
            val beginningGty = BigDecimal(beginning_gty)

            val beginningUnitType = getUnitTypeConstant(beginning_unit_type)
            val endingUnitType = getUnitTypeConstant(ending_unit_type)

            val ending_gty = BigDecimal.ONE.divide(beginningUnitType, MathContext.DECIMAL128)
                .multiply(endingUnitType, MathContext.DECIMAL128)
                .multiply(beginningGty, MathContext.DECIMAL128)

            return ending_gty.toString()
        }
        return ending_gty
    }

    fun setbeginning_gty(beginningGty: String) {
        this.beginning_gty = beginningGty
    }

    fun setbeginning_unit_type(beginningUnitType: String) {
        this.beginning_unit_type = beginningUnitType
    }

    fun setending_unit_type(endingUnitType: String) {
        this.ending_unit_type = endingUnitType
    }

    fun setEnding_gty() {
        this.ending_gty = calculateEndingQty()
    }
}