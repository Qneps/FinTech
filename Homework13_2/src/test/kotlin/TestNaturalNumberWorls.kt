import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class TestNaturalNumberWords {


    @ParameterizedTest
    @CsvSource(
        "-1", "1001", "0"
    )
    fun testNegativeNaturalNumberWords(n: Int) {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            NaturalNumberWords().getNaturalNumberWords(n)
        }
        Assertions.assertEquals("Значение должно быть в пределах от 1 до 1000: $n", exception.message)
    }

    @ParameterizedTest
    @MethodSource("numbers1_19")
    fun testPositiveNaturalNumberWords1_19(n: Int, expected: String) {
        Assertions.assertEquals(expected, NaturalNumberWords().getNaturalNumberWords(n),
            "Запись цифр не соответствует ожидамой")
    }
    @ParameterizedTest
    @MethodSource("numbers101_1000")
    fun testPositiveNaturalNumberWords101_1000(n: Int, expected: String) {
        Assertions.assertEquals(expected, NaturalNumberWords().getNaturalNumberWords(n),
            "Запись цифр не соответствует ожидамой")
    }
    companion object {
        @JvmStatic
        fun numbers1_19() = listOf(
            Arguments.of("1", "один"),
            Arguments.of("2", "два"),
            Arguments.of("3", "три"),
            Arguments.of("4", "четыре"),
            Arguments.of("5", "пять"),
            Arguments.of("6", "шесть"),
            Arguments.of("7", "семь"),
            Arguments.of("8", "восемь"),
            Arguments.of("9", "девять"),
            Arguments.of("10", "десять"),
            Arguments.of("11", "одиннадцать"),
            Arguments.of("12", "двенадцать"),
            Arguments.of("13", "тринадцать"),
            Arguments.of("14", "четырнадцать"),
            Arguments.of("15", "пятнадцать"),
            Arguments.of("16", "шестнадцать"),
            Arguments.of("17", "семнадцать"),
            Arguments.of("18", "восемнадцать"),
            Arguments.of("19", "девятнадцать")
        )
        @JvmStatic
        fun numbers101_1000() = listOf(
            Arguments.of("101", "сто один"),
            Arguments.of("222", "двести двадцать два"),
            Arguments.of("333", "триста тридцать три"),
            Arguments.of("444", "четыреста сорок четыре"),
            Arguments.of("555", "пятьсот пятьдесят пять"),
            Arguments.of("666", "шестьсот шестьдесят шесть"),
            Arguments.of("777", "семьсот семьдесят семь"),
            Arguments.of("888", "восемьсот восемьдесят восемь"),
            Arguments.of("999", "девятьсот девяносто девять"),
            Arguments.of("1000", "одна тысяча")
        )
    }




}