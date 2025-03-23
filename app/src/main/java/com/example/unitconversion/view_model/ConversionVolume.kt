package com.example.unitconversion.view_model

import androidx.lifecycle.ViewModel
import java.math.BigDecimal
import java.math.MathContext

class ConversionVolume: ViewModel() {
    var MetroCubico = "1.0"
    var CentimetroCubico = "1000000.0"
    var MilimetroCubico = "1000000000.0"
    var Litro = "1000.0"
    var Mililitro = "1000000.0"
    var GalaoUSA = "264.17205236"
    var QuartoUSA = "1056.6882094"
    var PintUSA = "2113.3764188"
    var CopoUSA = "4226.7528376"
    var ColherDeSopaUSA = "67628.045404"
    var ColherDeChaUSA = "202884.13621"
    var MilhaCubica = "2.399127585E-10"
    var JardaCubica = "1.3079506203"
    var PeCubico = "35.314666721"
    var PolegadaCubica = "61023.744054"
    var DecimetroCubico = "1000.0"
    var Exalitro = "1.0E-15"
    var Petalitro = "1.0E-12"
    var Teralitro = "1.0E-9"
    var Gigalitro = "1.0E-6"
    var Megalitro = "1.0E-3"
    var Kilolitro = "1.0"
    var Hectolitro = "10.0"
    var Decalitro = "100.0"
    var Decilitro = "10000.0"
    var Centilitro = "100000.0"
    var Microlitro = "1000000000.0"
    var Nanolitro = "1.0E+12"
    var Picolitro = "1.0E+15"
    var Femtolitro = "1.0E+18"
    var Atolitro = "1.0E+21"
    var Zeptolitro = "1.0E+24"
    var Drop = "50000000.0"
    var Teaspoon = "5000000.0"
    var Tablespoon = "15000000.0"
    var BarrilPetroleo = "6.2898107704"
    var BarrilUSA = "8.3864143606"
    var BarrilReinoUNido = "6.1102568972"
    var GalaoReinoUnido = "219.9692483"
    var QuartolReinoUnido = "879.8769932"
    var PintReinoUnido = "1759.753987"
    var CopoReinoUnido = "3519.527974"
    var OncaFluidaUsa = "33814.022702"
    var OncaFluidaReinoUnido = "35195.079728"

    var beginning_gty = ""
    var beginning_unit_type = ""
    var ending_gty = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Metro Cubico" -> BigDecimal(MetroCubico)
            "Centimetro Cubico" -> BigDecimal(CentimetroCubico)
            "Milimetro Cubico" -> BigDecimal(MilimetroCubico)
            "Litro" -> BigDecimal(Litro)
            "Mililitro" -> BigDecimal(Mililitro)
            "Galão (USA)" -> BigDecimal(GalaoUSA)
            "Quarto (USA)" -> BigDecimal(QuartoUSA)
            "Pint (USA)" -> BigDecimal(PintUSA)
            "Copo (USA)" -> BigDecimal(CopoUSA)
            "Colher de Sopa (USA)" -> BigDecimal(ColherDeSopaUSA)
            "Colher de Cha (USA)" -> BigDecimal(ColherDeChaUSA)
            "Milha Cubica" -> BigDecimal(MilhaCubica)
            "Jarda Cubica" -> BigDecimal(JardaCubica)
            "Pe Cubico" -> BigDecimal(PeCubico)
            "Polegada Cubica" -> BigDecimal(PolegadaCubica)
            "Decimetro Cubico" -> BigDecimal(DecimetroCubico)
            "Exalitro" -> BigDecimal(Exalitro)
            "Petalitro" -> BigDecimal(Petalitro)
            "Teralitro" -> BigDecimal(Teralitro)
            "Gigalitro" -> BigDecimal(Gigalitro)
            "Megalitro" -> BigDecimal(Megalitro)
            "Kilolitro" -> BigDecimal(Kilolitro)
            "Hectolitro" -> BigDecimal(Hectolitro)
            "Decalitro" -> BigDecimal(Decalitro)
            "Decilitro" -> BigDecimal(Decilitro)
            "Centilitro" -> BigDecimal(Centilitro)
            "Microlitro" -> BigDecimal(Microlitro)
            "Nanolitro" -> BigDecimal(Nanolitro)
            "Picolitro" -> BigDecimal(Picolitro)
            "Femtolitro" -> BigDecimal(Femtolitro)
            "Atolitro" -> BigDecimal(Atolitro)
            "Zeptolitro" -> BigDecimal(Zeptolitro)
            "Drop" -> BigDecimal(Drop)
            "Teaspoon (colher de chá)" -> BigDecimal(Teaspoon)
            "Tablespoon (colher de sopa)" -> BigDecimal(Tablespoon)
            "Barril Petroleo" -> BigDecimal(BarrilPetroleo)
            "Barril (USA)" -> BigDecimal(BarrilUSA)
            "Barril (Reino Unido)" -> BigDecimal(BarrilReinoUNido)
            "Galão (Reino Unido)" -> BigDecimal(GalaoReinoUnido)
            "Quarto (Reino Unido)" -> BigDecimal(QuartolReinoUnido)
            "Pint (Reino Unido)" -> BigDecimal(PintReinoUnido)
            "Copo (Reino Unido)" -> BigDecimal(CopoReinoUnido)
            "Onça Fluida (USA)" -> BigDecimal(OncaFluidaUsa)
            "Onça Fluida (Reino Unido)" -> BigDecimal(OncaFluidaReinoUnido)

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