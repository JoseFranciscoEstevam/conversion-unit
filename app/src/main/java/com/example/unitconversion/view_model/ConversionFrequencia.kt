package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionFrequencia: ViewModel() {
    var Hertz = "1.0"
    var QuiloHertz = "0.001"
    var MegaHertz = "0.000001"
    var GigaHertz = "0.000000001"
    var TeraHertz = "1.0E-12"
    var PicoHertz = "1.0E-15"

    var beginning_gty = ""
    var ending_gty = ""
    var beginning_unit_type = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Hertz" -> BigDecimal(Hertz)
            "QuiloHertz" -> BigDecimal(QuiloHertz)
            "MegaHertz" -> BigDecimal(MegaHertz)
            "GigaHertz" -> BigDecimal(GigaHertz)
            "TeraHertz" -> BigDecimal(TeraHertz)
            "PicoHertz" -> BigDecimal(PicoHertz)
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
                    .multiply(ending_unit_type, MathContext.DECIMAL128)
                    .multiply(beginning_gty, MathContext.DECIMAL128).toString()

                return ending_gty
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

