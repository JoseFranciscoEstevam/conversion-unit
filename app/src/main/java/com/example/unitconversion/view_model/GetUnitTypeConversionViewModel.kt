import androidx.lifecycle.ViewModel
import kotlin.math.PI


class GetUnitTypeConversionViewModel: ViewModel() {

    companion object {
        var sizeList = listOf(
            SizeOption("Area"),
            SizeOption("Angulo"),
            SizeOption("Armazenamento de Dados"),
            SizeOption("Comprimento"),
            SizeOption("Consumo de Combustivel"),
            SizeOption("Energia Mecanica"),
            SizeOption("Frequência"),
            SizeOption("Massa"),
            SizeOption("Pressão"),
            SizeOption("Temperatura"),
            SizeOption("Tempo"),
            SizeOption("Transmissão de Dados"),
            SizeOption("Velocidade"),
            SizeOption("Volume"),
        )
    }

    data class SizeOption(
        val sizeName: String
    )
    fun getUnitArea() = listOf(
        UnitList("Quilometro Quadrado", 1.0, "(km2)"),
        UnitList("Metro Quadrado", 1000000.0, "(m2)"),
        UnitList("Centimetro Quadrado", 1e+10, "(cm2)"),
        UnitList("Milimetro Quadrado", 1e+12, "(mm2)"),
        UnitList("Milha Quadrada", 0.38610215854245, "(mil2)"),
        UnitList("Jarda Quadrada", 1195990.05, "(yd2)"),
        UnitList("Polegada Quadrada", 1550003100.01, "(in2)"),
        UnitList("Pé Quadrado", 10763910.42, "(ft2)"),
        UnitList("Hectare", 100.0, "(ha)"),
        UnitList("Acre", 247.11, "(ac)")
    )

    fun getUnitAngulo() = listOf(
        UnitList("Grau", 1.0, "(°)"),
        UnitList("Grado", 1.1111111111111112, "gon"),
        UnitList("Mil Angular", 1000 * PI / 180, "(NATO)"),
        UnitList("Minuto de Arco", 60.0, "(MOA)"),
        UnitList("Radiano", PI / 180, "(rad)"),
        UnitList("Segundo de Arco", 3600.0, "(arcseg)")
    )

    fun getUnitArmazenamento() = listOf(

        UnitList("Bit", 1.0, "(b)"),
        UnitList("Kilobit", 0.001, "(kb)"),
        UnitList("Kibibit", 0.0009765625, "(kib)"),
        UnitList("Megabit", 0.000001, "(mb)"),
        UnitList("Mebibit", 9.532888465204957102001906577693e-7, "(Mebit)"),
        UnitList("Gigabit", 0.000000001, unitUnidade = "(gb)"),
        UnitList("Gibibit", 9.3109869646182495344506517690875e-10, "(Gibit)"),
        UnitList("Terabit", 0.000000000001, unitUnidade = "(tb)"),
        UnitList("Tebibit", 9.0909090909090909090909090909091e-13, "(Tibit)"),
        UnitList("Petabit", 0.000000000000001, unitUnidade = "(pb)"),
        UnitList("Pebibit", 8.8809946714031971580817051509769e-19, "(Pibit)"),
        UnitList("Byte", 0.125, "(B)"),
        UnitList("Kilobyte", 0.000125, "(KB)"),
        UnitList("Kibibyte", 0.0001220703125, "(KiB)"),
        UnitList("Megabyte", 0.000000125, "(MB)"),
        UnitList("Mebibyte", 1.1920371915603766837525330790321e-7, "(MiB)"),
        UnitList("Gigabyte", 0.000000000125, "(GB)"),
        UnitList("Gibibyte", 1.1641443538998835855646100116414e-10, "(GiB)"),
        UnitList("Terabyte", 0.000000000000125, unitUnidade = "(TB)"),
        UnitList("Tebibyte", 1.1368804001819008640291041382447e-13, "(Tib)"),
        UnitList("Petabyte", 0.000000000000000125, "(PB)"),
        UnitList("Pebibyte", 1.1102475852115021649827911624292e-16, "(PiB)")
    )

    fun getUnitComprimento() = listOf(
        UnitList("Metro", 1.0, "(m)"),
        UnitList("Centimetro", 100.0, "(cm)"),
        UnitList("Milimetro", 1000.0, "(mm)"),
        UnitList("Kilometro", 0.001, "(km)"),
        UnitList("Micrometro", 1000000.0, "(µm)"),
        UnitList("Nanometro", 1000000000.0, "nm"),
        UnitList("Polegada", 39.37007874015748031496062992126, "(in)"),
        UnitList("Pés", 3.2808398950131233595800524934383, "(ft)"),
        UnitList("Milha", 6.2137119223733396961743418436332e-4, "(mil)"),
        UnitList("Jarda", 1.0936132983377077865266841644794, "(yd)"),
        UnitList("Milha Náutica", 5.3995680345572354211663066954644e-4, "(milnau)")
    )

    fun getUnitEnergiaMecanica() = listOf(
        UnitList("Joule", 1.0, "(J)"),
        UnitList("Kilojoule", 0.001, "(kJ)"),
        UnitList("Gram Calorie", 0.239005736137667304015, "(cal)"),
        UnitList("Kilocalorie", 0.000239005736137667304, "(kcal)"),
        UnitList("Watt-Hora", 0.000277777777777777777, "(Wh)"),
        UnitList("KiloWatt-Hora", 2.7777777777777777777e-7, "(kWh)"),
        UnitList("Eletron-Volt", 6.242E+18, "(eV)"),
        UnitList("BTU", 9.4786729857819905213270142180095e-4, "(BTU)"),
        UnitList("therm(USA)", 9.4786729857819905213270142180095e-9, "(thUS)"),
        UnitList("Pé-libra Força", 0.73746312684365781710914454277286, "(PSI)")
    )

    fun getUnitConsumo(): List<UnitList> {
        val Litropor100Kilometros = 1.0
        return listOf(
            UnitList("Litro por 100 Kilometros", 1.0, "(l/km)"),
            UnitList("Milha por Galão Americano", 235.215 / Litropor100Kilometros, "(mga)"),
            UnitList("Milha por Galão Imperial", 282.481 / Litropor100Kilometros, "(mgi)"),
            UnitList("Kilometro por Litro", 100.0 / Litropor100Kilometros, "(km/l)"),
            UnitList("Metro por Litro", 0.000010 / Litropor100Kilometros, "(m/l)")
        )
    }
    fun getUnitFrequencia() = listOf(
        UnitList("Hertz", 1.0, "(Hz)"),
        UnitList("QuiloHertz", 0.001, "(kHz)"),
        UnitList("MegaHertz", 0.000001, "(MHz)"),
        UnitList("GigaHertz", 1.0E-9, "(GHz)"),
    )
    fun getUnitMassa() = listOf(
        UnitList("Quilograma", 1.0, "(Kg)"),
        UnitList("Grama", 1000.0, "(g)"),
        UnitList("Miligrama", 1E+6, "(mg)"),
        UnitList("Micrograma", 1E+9, "(µg)"),
        UnitList("Tonelada", 0.0001, "(t)"),
        UnitList("Tonelada Deslocamento", 9.842519685039370078740157480315e-4, "(long ton)"),
        UnitList("Tonelada Curta", 0.00110253583241455347298787210584, "(short ton)"),
        UnitList("Stone", 0.15748031496062992125984251968504, "(st)"),
        UnitList("Libra", 2.205, "(lb)"),
        UnitList("Onça", 35.274, "(oz)")
    )
    fun getUnitPressao() = listOf(
        UnitList("Atmosfera Padrão", 1.0, "(atm)"),
        UnitList("Bar", 1.01325, "(bar)"),
        UnitList("Pascal", 101325.0, "(Pa)"),
        UnitList("Psi", 14.6959, "(psi)"),
        UnitList("Torr", 760.0, "(torr)")
    )
    fun getUnitTemperatura(): List<UnitList> {
        val GrauCelcius = 1.0
        return listOf(
            UnitList("Grau Celsius", 1.0, "(°C)"),
            UnitList("Grau Fahrenheit", (GrauCelcius) * 9 / 5 + 32, "(°F)"),
            UnitList("Grau Kelvin", (GrauCelcius) + 273.15, "(°K)")
        )
    }
//    fun getUnitTemperaturaFCK(): List<UnitList> {
//        val GrauFahrenheit = 1.0
//        return listOf(
//            UnitList("Grau Fahrenheit", 1.0, "(°F)"),
//            UnitList("Grau Celsius", (GrauFahrenheit - 32) * 5 / 9, "(°C)"),
//            UnitList("Grau Kelvin", (GrauFahrenheit - 32) * 5 / 9 + 273.15, "(°K)")
//        )
//    }
//    fun getUnitTemperaturaKFC(): List<UnitList> {
//        val GrauKelvin = 1.0
//        return listOf(
//            UnitList("Grau Kelvin", 1.0, "(°K)"),
//            UnitList("Grau Celsius", (GrauKelvin - 32) * 5 / 9, "(°C)"),
//            UnitList("Grau Fahrenheit", (GrauKelvin - 273.15) * 9 / 5 + 32, "(°F)")
//        )
//    }
    fun getUnitTempo() = listOf(
        UnitList("Nanosegundo", 1.0, "(ns)"),
        UnitList("Microsegundo", 0.001, "(µs)"),
        UnitList("Milissegundo", 0.000001, "(ms)"),
        UnitList("Segundo", 1.0, "(s)"),
        UnitList("Minuto", 60.0, "(min)"),
        UnitList("Hora", 3600.0, "(h)"),
        UnitList("Dia", 86400.0, "(d)"),
        UnitList("Semana", 604800.0, "(w)"),
        UnitList("Mes", 2628000.0, "(mo)"),
        UnitList("Ano Calendario", 31536000.0, "(a)"),
        UnitList("Decada", 315360000.0, "(de)"),
        UnitList("Seculo", 3153600000.0, "(se)"),
        UnitList("Milenio", 3153600000.0, "(mil)"),
    )
//    fun getUnitTransmissaoDados() = listOf(
//        UnitList("Bit", 1.0, "(b)"),
//        UnitList("Kilobit", 0.001, "(kb)"),
//        UnitList("Kibibit", 0.0009765625, "(kib)"),
//        UnitList("Megabit", 0.000001, "(mb)"),
//        UnitList("Mebibit", 9.532888465204957102001906577693e-7, "(Mebit)"),
//        UnitList("Gigabit", 0.000000001,"(gb)"),
//        UnitList("Gibibit", 9.3109869646182495344506517690875e-10, "(Gibit)"),
//        UnitList("Terabit", 0.000000000001,"(tb)"),
//        UnitList("Tebibit", 9.0909090909090909090909090909091e-13, "(Tibit)"),
//        UnitList("Petabit", 0.000000000000001,"(pb)"),
//        UnitList("Pebibit", 8.8809946714031971580817051509769e-19, "(Pibit)"),
//        UnitList("Byte", 0.125, "(B)"),
//        UnitList("Kilobyte", 0.000125, "(KB)"),
//        UnitList("Kibibyte", 0.0001220703125, "(KiB)"),
//        UnitList("Megabyte", 0.000000125, "(MB)"),
//        UnitList("Mebibyte", 1.1920371915603766837525330790321e-7, "(MiB)"),
//        UnitList("Gigabyte", 0.000000000125, "(GB)"),
//        UnitList("Gibibyte", 1.1641443538998835855646100116414e-10, "(GiB)"),
//        UnitList("Terabyte", 0.000000000000125, unitUnidade = "(TB)"),
//        UnitList("Tebibyte", 1.1368804001819008640291041382447e-13, "(Tib)"),
//        UnitList("Petabyte", 0.000000000000000125, "(PB)"),
//        UnitList("Pebibyte", 1.1102475852115021649827911624292e-16, "(PiB)"),
//    )

    fun getUnitTransmissaoDados() = listOf(
        UnitList("Bit por Segundo", 1.0, "(b)"),
        UnitList("Kilobit por Segundo", 0.001, "(kb)"),
        UnitList("Kibibit por Segundo", 0.0009765625, "(kib)"),
        UnitList("Megabit por Segundo", 0.000001, "(mb)"),
        UnitList("Mebibit por Segundo", 9.532888465204957102001906577693e-7, "(Mebit)"),
        UnitList("Gigabit por Segundo", 0.000000001, unitUnidade = "(gb)"),
        UnitList("Gibibit por Segundo", 9.3109869646182495344506517690875e-10, "(Gibit)"),
        UnitList("Terabit por Segundo", 0.000000000001, unitUnidade = "(tb)"),
        UnitList("Tebibit por Segundo", 9.0909090909090909090909090909091e-13, "(Tibit)"),
        UnitList("Petabit por Segundo", 0.000000000000001, unitUnidade = "(pb)"),
        UnitList("Pebibit por Segundo", 8.8809946714031971580817051509769e-19, "(Pibit)"),
        UnitList("Byte por Segundo", 0.125, "(B)"),
        UnitList("Kilobyte por Segundo", 0.000125, "(KB)"),
        UnitList("Kibibyte por Segundo", 0.0001220703125, "(KiB)"),
        UnitList("Megabyte por Segundo", 0.000000125, "(MB)"),
        UnitList("Mebibyte por Segundo", 1.1920371915603766837525330790321e-7, "(MiB)"),
        UnitList("Gigabyte por Segundo", 0.000000000125, unitUnidade = "(GB)"),
        UnitList("Gibibyte por Segundo", 1.1641443538998835855646100116414e-10, "(GiB)"),
        UnitList("Terabyte por Segundo", 0.000000000000125, unitUnidade = "(TB)"),
        UnitList("Tebibyte por Segundo", 1.1368804001819008640291041382447e-13, "(Tib)"),
        UnitList("Petabyte por Segundo", 0.000000000000000125, "(PB)"),
        UnitList("Pebibyte por Segundo", 1.1102475852115021649827911624292e-16, "(PiB)"),
    )
    fun getUnitVelocidade() = listOf(
        UnitList("Metro por Segundo", 1.0, "(m/s)"),
        UnitList("Metro por Minuto", 60.0 , "(m/min)"),
        UnitList("Metro por Hora", 3.600, "(m/h)"),
        UnitList("Centimetro por Segundo", 100.0, "(cm/s)"),
        UnitList("Centimetro por Minuto", 6000.0, "(cm/min)"),
        UnitList("Centimetro por Hora", 360000.0, "(cm/h)"),
        UnitList("Milimetro por Segundo", 1000.0, "(mm/s)"),
        UnitList("Milimetro por Minuto", 60000.0, "(mm/min)"),
        UnitList("Milimetro por Hora", 3600000.0, "(mm/h)"),
        UnitList("Quilometro por Segundo", 0.001, "(km/s)"),
        UnitList("Quilometro por Minuto", 0.06, "(km/min)"),
        UnitList("Quilometro por Hora", 3.6, "(km/h)"),
        UnitList("Milha por Hora", 2.2369362920544022906227630637079, "(milha/h)"),
        UnitList("Milha por Minuto", 0.0083333333333333333333333333333333, "(milha/min)"),
        UnitList("Milha por Segundo", 0.00062137119223733396961743418436332, "(milha/s)"),
        UnitList("Jarda por Segundo", 1.0936132983377077865266841644794, "(yd/s)"),
        UnitList("Jarda por Minuto", 0.0000166666666666666666666666666666666, "(yd/min)"),
        UnitList("Jarda por Hora", 0.000277777777777777777, "(yd/h)"),
        UnitList("Polegada por Segundo", 39.37007874015748031496062992126, "(in/s)"),
        UnitList("Polegada por Minuto", 0.0000166666666666666666666666666666666, "(in/min)"),
        UnitList("Polegada por Hora", 0.000277777777777777777, "(in/h)"),
        UnitList("Pés por Segundo", 3.2808398950131233595800524934383, "(ft/s)"),
        UnitList("Pés por Minuto", 0.0000166666666666666666666666666666666, "(ft/min)"),
        UnitList("Pés por Hora", 11810.977122137314420021968417447, "(ft/h)"),
        UnitList("Nó", 1.9438444924 , "(kt)"),
        UnitList("Nó (Reino Unido)", 1.9426025694, "(kt-Reino Unido)"),
        UnitList("velocidade da Luz", 299792458.0, "(m/s)"),
        UnitList("Velocidade do Som (ar)", 343.0, "(m/s)"),
        UnitList("Velocidade do Som (água)", 1480.0, "(m/s)"),
        UnitList("Velocidade do Som (aço)", 6000.0, "(m/s)")
    )
    fun getUnitVolume() = listOf(
        UnitList("Metro Cubico", 1.0,  "(m^3)"),
        UnitList("Centimetro Cubico", 1000000.0, "(cm^3)"),
        UnitList("Milimetro Cubico", 1000000000.0, "(mm^3)"),
        UnitList("Kilometro Cubico", 0.000000001, "(km^3)"),
        UnitList("Litro", 1000.0, "(l)"),
        UnitList("Mililitro", 1000000.0, "(ml)"),
        UnitList("Galão (USA)", 264.17205236, "(gal (USA))"),
        UnitList("Quarto (USA)", 1056.6882094, "(qt (USA))"),
        UnitList("Pint (USA)", 2113.3764189, "(pt (USA))"),
        UnitList("Copo (USA)", 4226.7528377, "(cp (USA))"),
        UnitList("Colher de Sopa (USA)", 67628.045404, "(cs (USA))"),
        UnitList("Colher de Chá (USA)", 202884.13621, "(cc (USA))"),
        UnitList("Milha Cubica", 2.399127585E-10, "(mi^3)"),
        UnitList("Jarda Cubica", 1.3079506193, "(yd^3)"),
        UnitList("Pé Cubico", 35.314666721, "(ft^3)"),
        UnitList("Polegada Cubica", 61023.744054, "(in^3))"),
        UnitList("Decimetro Cubico", 1000.0, ("dm^3")),
        UnitList("Exalitro", 1.0E-15, "(EL"),
        UnitList("Petalitro", 1.0E-12, "(PL)"),
        UnitList("Teralitro", 1.0E-9, "(TL)"),
        UnitList("Gigalitro", 1.0E-6, "(GL)"),
        UnitList("Megalitro", 1.0E-3, "(ML)"),
        UnitList("Kilolitro", 1.0, "(QL)"),
        UnitList("Hectolitro", 10.0, "(hl)"),
        UnitList("Decalitro", 100.0, "(dal)"),
        UnitList("Decilitro", 1000.0,"(dl)"),
        UnitList("Centilitro", 10000.0, "(cl)"),
        UnitList("Microlitro", 1000000000.0, "(µl)"),
        UnitList("Nanolitro", 1000000000000.0, "(nl)"),
        UnitList("Picolitro", 1000000000000000.0, "(pl)"),
        UnitList("Femtolitro", 1000000000000000000.0, "(fl)"),
        UnitList("Atolitro", 1000000000000000000000.0, "(al)"),
        UnitList("Zeptolitro", 1000000000000000000000000.0, "(zl)"),
        UnitList("Drop (gota)", 20000000.0,"(dr)"),
        UnitList("Teaspoon (colher de chá)", 5000000.0, "(tsp)"),
        UnitList("Tablespoon (colher de sopa)", 15000000.0, "(tbsp)"),
        UnitList("Barril (Petroleo)", 6.2898107704, "(bbl (petroleo))"),
        UnitList("Barril (USA)", 8.3864143606, "(bbl (USA))"),
        UnitList("Barril (Reino Unido)", 6.1102568972, "(bbl (Reino Unido)"),
        UnitList("Galão (Reino Unido)", 219.9692483, "(gal (Reino Unido)"),
        UnitList("Quarto (Reino Unido)", 879.8769932, "(qt (Reino Unido)"),
        UnitList("Pint (Reino Unido)", 1759.7539864, "(pt (Reino Unido"),
        UnitList("Copo (Reino Unido)", 3519.5079728, "(cp)"),
        UnitList("Onça Fluida (USA)", 33814.022702, "(fl oz"),
        UnitList("Onça Fluida (Reino Unido)", 35195.079728, "(fl oz")

    )

    data class UnitList(
        val unitName: String,
        val unitConstant: Double,
        val unitUnidade: String,

    )
}