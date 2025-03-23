package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionArea: ViewModel() {
    var QuilometroQuadrado = "1.00"
    var MetroQuadrado = "1000000.00"
    var CentimetroQuadrado = "10000000000.00"
    var MilimetroQuadrado = "1000000000000.00"
    var MilhaQuadrada = "38610215854245E-14"
    var JardaQuadrada = "1195990.05"
    var PolegadaQuadrada = "1550003100.01"
    var PeQuadrado = "10763910.42"
    var Hectare = "100.00"
    var Acre = "247.10436922533"

    var beginning_gty: String = ""
    var beginning_unit_type: String = ""
    var ending_unit_type: String = ""
    var ending_gty: String = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Quilometro Quadrado" -> BigDecimal(QuilometroQuadrado)
            "Metro Quadrado" -> BigDecimal(MetroQuadrado)
            "Centimetro Quadrado" -> BigDecimal(CentimetroQuadrado)
            "Milimetro Quadrado" -> BigDecimal(MilimetroQuadrado)
            "Milha Quadrada" -> BigDecimal(MilhaQuadrada)
            "Jarda Quadrada" -> BigDecimal(JardaQuadrada)
            "Polegada Quadrada" -> BigDecimal(PolegadaQuadrada)
            "Pé Quadrado" -> BigDecimal(PeQuadrado)
            "Hectare" -> BigDecimal(Hectare)
            "Acre" -> BigDecimal(Acre)
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

            val ending_gty = BigDecimal.ONE.divide (beginning_unit_type, MathContext.DECIMAL128)
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