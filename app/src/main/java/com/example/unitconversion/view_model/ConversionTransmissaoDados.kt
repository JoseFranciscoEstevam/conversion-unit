package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionTransmissaoDados: ViewModel() {
    var Bitsegundo = "1.0"
    var Kilobitsegundo = "0.001"
    var Kibibitsegundo = "0.0009765625"
    var Megabitsegundo = "0.000001"
    var Mebibitsegundo = "9.532888465204957102001906577693e-7"
    var Gigabitsegundo = "0.000000001"
    var Gibibitsegundo = "9.3109869646182495344506517690875e-10"
    var Terabitsegundo = "0.000000000001"
    var Tebibitsegundo = "9.0909090909090909090909090909091e-13"
    var Petabitsegundo = "0.000000000000001"
    var Pebibitsegundo = "8.8809946714031971580817051509769e-19"
    var Bytesegundo = "0.125"
    var Kilobytesegundo = "0.000125"
    var Kibibytesegundo = "0.0001220703125"
    var Megabytesegundo = "0.000000125"
    var Mebibytesegundo = "1.1920371915603766837525330790321e-7"
    var Gigabytesegundo = "0.000000000125"
    var Gibibytesegundo = "1.1641443538998835855646100116414e-10"
    var Terabytesegundo = "0.000000000000125"
    var Tebibytesegundo = "1.1368804001819008640291041382447e-13"
    var Petabytesegundo = "0.000000000000000125"
    var Pebibytesegundo = "1.1102475852115021649827911624292e-16"

    var beginning_gty = ""
    var beginning_unit_type = ""
    var ending_gty = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Bit por Segundo" -> BigDecimal(Bitsegundo)
            "Kilobit por Segundo" -> BigDecimal(Kilobitsegundo)
            "Kibibit por Segundo" -> BigDecimal(Kibibitsegundo)
            "Megabit por Segundo" -> BigDecimal(Megabitsegundo)
            "Mebibit por Segundo" -> BigDecimal(Mebibitsegundo)
            "Gigabit por Segundo" -> BigDecimal(Gigabitsegundo)
            "Gibibit por Segundo" -> BigDecimal(Gibibitsegundo)
            "Terabit por Segundo" -> BigDecimal(Terabitsegundo)
            "Tebibit por Segundo" -> BigDecimal(Tebibitsegundo)
            "Petabit por Segundo" -> BigDecimal(Petabitsegundo)
            "Pebibit por Segundo" -> BigDecimal(Pebibitsegundo)
            "Byte por Segundo" -> BigDecimal(Bytesegundo)
            "Kilobyte por Segundo" -> BigDecimal(Kilobytesegundo)
            "Kibibyte por Segundo" -> BigDecimal(Kibibytesegundo)
            "Megabyte por Segundo" -> BigDecimal(Megabytesegundo)
            "Mebibyte por Segundo" -> BigDecimal(Mebibytesegundo)
            "Gigabyte por Segundo" -> BigDecimal(Gigabytesegundo)
            "Gibibyte por Segundo" -> BigDecimal(Gibibytesegundo)
            "Terabyte por Segundo" -> BigDecimal(Terabytesegundo)
            "Tebibyte por Segundo" -> BigDecimal(Tebibytesegundo)
            "Petabyte por Segundo" -> BigDecimal(Petabytesegundo)
            "Pebibyte por Segundo" -> BigDecimal(Pebibytesegundo)

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