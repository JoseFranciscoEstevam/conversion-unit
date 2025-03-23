package com.example.unitconversion.view_model


import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionComprimento: ViewModel() {
    var Metro = "1.00"
    var Centimetro = "100.00"
    var Milimetro = "1000.00"
    var Kilometro = "0.001"
    var Micrometro = "1000000.00"
    var Nanometro = "1000000000.00"
    var Polegada = "39.37007874015748031496062992126"
    var Pes = "3.2808398950131233595800524934383"
    var Milha = "6.2137119223733396961743418436332e-4"
    var Jarda = "1.0936132983377077865266841644794"
    var Milha_Nautica = "5.3995680345572354211663066954644e-4"

    var beginning_gty = ""
    var beginning_unit_type = ""
    var ending_gty = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Metro" -> BigDecimal(Metro)
            "Centimetro" -> BigDecimal(Centimetro)
            "Milimetro" -> BigDecimal(Milimetro)
            "Kilometro" -> BigDecimal(Kilometro)
            "Micrometro" -> BigDecimal(Micrometro)
            "Nanometro" -> BigDecimal(Nanometro)
            "Polegada" -> BigDecimal(Polegada)
            "Pés" -> BigDecimal(Pes)
            "Jarda" -> BigDecimal(Jarda)
            "Milha" -> BigDecimal(Milha)
            "Milha Nautica" -> BigDecimal(Milha_Nautica)
            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String {

        if (beginning_gty == "0"){
            ending_gty = "0.00"
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