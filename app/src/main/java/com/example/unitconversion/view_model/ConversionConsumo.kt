package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext
import kotlin.text.toBigDecimal

class ConversionConsumo: ViewModel() {
    var Litrospor100Kilometros = BigDecimal("1.00")
    var MilhaporGalaoAmericano = BigDecimal("235.215")
    var MilhaporGalaoImperial = BigDecimal("282.481")
    var KilometrosporLitro = BigDecimal("100.0")

    var ending_qty: String = ""
    var beginning_qty: String = ""
    var beginning_unit_type: String = ""
    var ending_unit_type: String = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Litro por 100 Kilometros" -> Litrospor100Kilometros
            "Milha por Galão Americano" -> MilhaporGalaoAmericano
            "Milha por Galão Imperial" -> MilhaporGalaoImperial
            "Kilometro por Litro" -> KilometrosporLitro

            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String {
        val beginningQty = BigDecimal(beginning_qty)
        val beginningUnitType = getUnitTypeConstant(beginning_unit_type)
        val endingUnitType = getUnitTypeConstant(ending_unit_type)

        if (beginningUnitType == KilometrosporLitro && endingUnitType == Litrospor100Kilometros) {
            ending_qty = BigDecimal(100.00).divide(beginningQty, MathContext.DECIMAL128).toString()
        } else
            if (beginningUnitType == MilhaporGalaoImperial && endingUnitType == Litrospor100Kilometros) {
                ending_qty = BigDecimal(282.481).divide(beginningQty, MathContext.DECIMAL128).toString()
            } else
                if (beginningUnitType == MilhaporGalaoAmericano && endingUnitType == Litrospor100Kilometros) {
                    ending_qty = BigDecimal(235.215).divide(beginningQty, MathContext.DECIMAL128).toString()
                } else {
                    ending_qty =
                        BigDecimal.ONE.divide(beginningUnitType.toString().toBigDecimal(), MathContext.DECIMAL128)
                            .multiply(endingUnitType.toString().toBigDecimal(), MathContext.DECIMAL128)
                            .multiply(beginningQty).toString()
                }
        return ending_qty
    }

    fun setbeginning_gty(beginningGty: String) {
        this.beginning_qty = beginningGty
    }

    fun setbeginning_unit_type(beginningUnitType: String) {
        this.beginning_unit_type = beginningUnitType
    }

    fun setending_unit_type(endingUnitType: String) {
        this.ending_unit_type = endingUnitType
    }

    fun setEnding_gty() {
        this.ending_qty = calculateEndingQty()
    }
}