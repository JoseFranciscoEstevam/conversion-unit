package com.example.unitconversion.view_model

import java.math.BigDecimal
import java.math.MathContext

class ConversionVelocidades {
    var MetroSegundo = "1.0"
    var MetroMinuto = "60.0"
    var MetroHora = "3600.0"
    var CentimetroSegundo = "100.0"
    var CentimetroMinuto = "6000.0"
    var CentimetroHora = "360000.0"
    var MilimetroSegundo = "1000.0"
    var MilimetroMinuto = "60000.0"
    var MilimetroHora = "3600000.0"
    var QuilometroSegundo = "0.001"
    var QuilometroMinuto = "0.06"
    var QuilometroHora = "3.6"

    var MilhaSegundo = "0.00062137119223733396961743418436332"
    var MilhaMinuto = "0.037282222222222222222222222222222"
    var MilhaHora = "2.2369362920544022906227630637079"
    var JardaSegundo = "1,0936132983377077865266841644794"
    var JardaMinuto = "65.6166666666666666666666666666667"
    var JardaHora = "3937.007874015748031496062992126"
    var PolegadaSegundo = "0.00002777777777777777777777777777778"
    var PolegadaMinuto = "0.000000333333333333333333333333333333"
    var PolegadaHora = "0.0000000033333333333333333333333333333"
    var PeSegundo = "3.280839895"
    var PeMinuto = "196.850393701"
    var PeHora = "11810.977122137314420021968417447"
    var No = "1.9438444924"
    var NoReinoUnido = "1.9426025694"
    var velocidadeLuz = "299792458.0"
    var VelocidadeSomar = "343.0"
    var VelocidadeSomagua = "1480.0"
    var VelocidadeSomaco = "5000.0"


    var beginning_gty = ""
    var beginning_unit_type = ""
    var ending_gty = ""
    var ending_unit_type = ""

    fun getUnitTypeConstant(unitType: String): BigDecimal {
        return when (unitType) {
            "Metro por Segundo" -> BigDecimal(MetroSegundo)
            "Metro por Minuto" -> BigDecimal(MetroMinuto)
            "Metro por Hora" -> BigDecimal(MetroHora)
            "Centimetro por Segundo" -> BigDecimal(CentimetroSegundo)
            "Centimetro por Minuto" -> BigDecimal(CentimetroMinuto)
            "Centimetro por Hora" -> BigDecimal(CentimetroHora)
            "Milimetro por Segundo" -> BigDecimal(MilimetroSegundo)
            "Milimetro por Minuto" -> BigDecimal(MilimetroMinuto)
            "Milimetro por Hora" -> BigDecimal(MilimetroHora)

            "Quilometro por Segundo" -> BigDecimal(QuilometroSegundo)
            "Quilometro por Minuto" -> BigDecimal(QuilometroMinuto)
            "Quilometro por Hora" -> BigDecimal(QuilometroHora)

            "Milha por Segundo" -> BigDecimal(MilhaSegundo)
            "Milha por Minuto" -> BigDecimal(MilhaMinuto)
            "Milha por Hora" -> BigDecimal(MilhaHora)
            "Jarda por Segundo" -> BigDecimal(JardaSegundo)
            "Jarda por Minuto" -> BigDecimal(JardaMinuto)
            "Jarda Por Hora" -> BigDecimal(JardaHora)
            "Polegada por Segundo" -> BigDecimal(PolegadaSegundo)
            "Polegada por Minuto" -> BigDecimal(PolegadaMinuto)
            "Polegada por Hora" -> BigDecimal(PolegadaHora)
            "Pés por Segundo" -> BigDecimal(PeSegundo)
            "Pés por Minuto" -> BigDecimal(PeMinuto)
            "Pés por Hora" -> BigDecimal(PeHora)
            "Nó" -> BigDecimal(No)
            "Nó (Reino Unido)" -> BigDecimal(NoReinoUnido)
            "Velocidade da luz" -> BigDecimal(velocidadeLuz)
            "Velocidade do Som (ar)" -> BigDecimal(VelocidadeSomar)
            "Velocidade do Som (água)" -> BigDecimal(VelocidadeSomagua)
            "Velocidade do Som (aço)" -> BigDecimal(VelocidadeSomaco)


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