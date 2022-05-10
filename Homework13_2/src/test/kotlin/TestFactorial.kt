import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import java.math.BigInteger

class TestFactorial {
    @ParameterizedTest
    @CsvSource(
        "0", "-1", "101"
    )
    fun testNegativeFactorial(f: Int) {
        val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
            Factorial().getFactorial(f)
        }
        Assertions.assertEquals("Значение должно быть в пределах от 1 до 100: $f", exception.message)
    }

    @Test
    fun testPositiveOne() {
        val expected =  BigInteger.valueOf(1)
        Assertions.assertEquals(expected, Factorial().getFactorial(1))
    }

    @Test
    fun testPositiveOneHundred() {
        val expected = "933262154439441526816992388562667004907159682643816214685929638952175999" +
                "93229915608941463976156518286253697920827223758251185210916864000000000000000000000000"
        Assertions.assertEquals(expected, Factorial().getFactorial(100).toString())
    }
}