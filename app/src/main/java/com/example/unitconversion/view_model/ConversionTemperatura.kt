package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionTemperatura: ViewModel() {
    companion object {
        val BASE_CELSIUS = BigDecimal(1.00)
        val BASE_FAHRENHEIT = BigDecimal(1.00)
        val BASE_KELVIN = BigDecimal(1.00)
    }

    var beginning_gty = "0.0"
    var ending_gty = ""
    var beginning_unit_type = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Grau Celsius" -> BASE_CELSIUS
            "Grau Fahrenheit" -> BASE_FAHRENHEIT
            "Grau Kelvin" -> BASE_KELVIN
            else -> BigDecimal.ONE
        }
    }

    fun calculateEndingQty(): String {
        val beginningQty = BigDecimal(beginning_gty)
        val beginningUnit = getUnitTypeConstant(beginning_unit_type)
        val endingUnit = getUnitTypeConstant(ending_unit_type)

        ending_gty = when (beginning_unit_type) {
            "Grau Celsius" -> {
                when (ending_unit_type) {
                    "Grau Celsius" -> beginningQty.toString()
                    "Grau Fahrenheit" -> (beginningQty.multiply(BigDecimal(9), MathContext.DECIMAL128)
                        .divide(BigDecimal(5), MathContext.DECIMAL128))
                        .add(BigDecimal(32), MathContext.DECIMAL128).toString()
                    "Grau Kelvin" -> beginningQty.add(BigDecimal(273.15)).toString()
                    else -> ""
                }
            }
            "Grau Fahrenheit" -> {
                when (ending_unit_type) {
                    "Grau Fahrenheit" -> beginningQty.toString()
                    "Grau Celsius" -> (beginningQty.subtract(BigDecimal(32), MathContext.DECIMAL128))
                        .multiply(BigDecimal(5), MathContext.DECIMAL128)
                        .divide(BigDecimal(9), MathContext.DECIMAL128).toString()
                    "Grau Kelvin" -> (beginningQty.subtract(BigDecimal(32), MathContext.DECIMAL128))
                        .multiply(BigDecimal(5), MathContext.DECIMAL128)
                        .divide(BigDecimal(9), MathContext.DECIMAL128)
                        .add(BigDecimal(273.15)).toString()
                    else -> ""
                }
            }
            "Grau Kelvin" -> {
                when (ending_unit_type) {
                    "Grau Kelvin" -> beginningQty.toString()
                    "Grau Celsius" -> beginningQty.subtract(BigDecimal(273.15)).toString()
                    "Grau Fahrenheit" -> beginningQty.subtract(BigDecimal(273.15))
                        .multiply(BigDecimal(9), MathContext.DECIMAL128)
                        .divide(BigDecimal(5), MathContext.DECIMAL128)
                        .add(BigDecimal(32), MathContext.DECIMAL128).toString()
                    else -> ""
                }
            }

            else -> ""
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