package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionArmazenamento: ViewModel() {
    var Bit = "1.0"
    var Kilobit = "0.001"
    var Kibibit = "0.0009765625"
    var Megabit = "0.000001"
    var Mebibit = "9.532888465204957102001906577693e-7"
    var Gigabit = "0.000000001"
    var Gibibit = "9.3109869646182495344506517690875e-10"
    var Terabit = "0.000000000001"
    var Tebibit = "9.0909090909090909090909090909091e-13"
    var Petabit = "0.000000000000001"
    var Pebibit = "8.8809946714031971580817051509769e-19"
    var Byte = "0.125"
    var Kilobyte = "0.000125"
    var Kibibyte = "0.0001220703125"
    var Megabyte = "0.000000125"
    var Mebibyte = "1.1920371915603766837525330790321e-7"
    var Gigabyte = "0.000000000125"
    var Gibibyte = "1.1641443538998835855646100116414e-10"
    var Terabyte = "0.000000000000125"
    var Tebibyte = "1.1368804001819008640291041382447e-13"
    var Petabyte = "0.000000000000000125"
    var Pebibyte = "1.1102475852115021649827911624292e-16"

    var beginning_gty = ""
    var beginning_unit_type = ""
    var ending_gty = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Bit" -> BigDecimal(Bit)
            "Kilobit" -> BigDecimal(Kilobit)
            "Kibibit" -> BigDecimal(Kibibit)
            "Megabit" -> BigDecimal(Megabit)
            "Mebibit" -> BigDecimal(Mebibit)
            "Gigabit" -> BigDecimal(Gigabit)
            "Gibibit" -> BigDecimal(Gibibit)
            "Terabit" -> BigDecimal(Terabit)
            "Tebibit" -> BigDecimal(Tebibit)
            "Petabit" -> BigDecimal(Petabit)
            "Pebibit" -> BigDecimal(Pebibit)
            "Byte" -> BigDecimal(Byte)
            "Kilobyte" -> BigDecimal(Kilobyte)
            "Kibibyte" -> BigDecimal(Kibibyte)
            "Megabyte" -> BigDecimal(Megabyte)
            "Mebibyte" -> BigDecimal(Mebibyte)
            "Gigabyte" -> BigDecimal(Gigabyte)
            "Gibibyte" -> BigDecimal(Gibibyte)
            "Terabyte" -> BigDecimal(Terabyte)
            "Tebibyte" -> BigDecimal(Tebibyte)
            "Petabyte" -> BigDecimal(Petabyte)
            "Pebibyte" -> BigDecimal(Pebibyte)
            else -> BigDecimal.ONE
        }
    }
    fun calculateEndingQty(): String {
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