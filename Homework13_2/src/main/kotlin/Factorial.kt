
import java.math.BigInteger

class Factorial {
    fun getFactorial(f: Int): BigInteger? {
        if(f in 0..100)
          return calculationFactorial(f)
        else
            throw IllegalArgumentException("Значение должно быть в пределах от 1 до 100: $f")
    }


    private fun calculationFactorial(f: Int): BigInteger? {
        return if (f <= 1) {
            BigInteger.valueOf(1)
        } else {
            BigInteger.valueOf(f.toLong()).multiply(calculationFactorial(f - 1))
        }
    }
}