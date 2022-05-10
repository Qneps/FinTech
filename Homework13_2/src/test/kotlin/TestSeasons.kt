import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class TestSeasons {

   @ParameterizedTest
   @CsvSource(
      "1", "2", "12"
   )
   fun testPositiveWinter(n: Int) {
      Assertions.assertEquals("Winter",Seasons().getSeason(n))
   }
   @ParameterizedTest
   @CsvSource(
      "3", "4", "5"
   )
   fun testPositiveSpring(n: Int) {
      Assertions.assertEquals("Spring",Seasons().getSeason(n))
   }

   @ParameterizedTest
   @CsvSource(
      "9", "10", "11"
   )
   fun testPositiveAutumn(n: Int) {
      Assertions.assertEquals("Autumn",Seasons().getSeason(n))
   }

   @ParameterizedTest
   @CsvSource(
      "6", "7", "8"
   )
   fun testPositiveSummer(n: Int) {
      Assertions.assertEquals("Summer",Seasons().getSeason(n))
   }

   @ParameterizedTest
   @CsvSource(
      "0", "-1", "13"
   )
   fun testNegative(n: Int) {
      val exception = Assertions.assertThrows(IllegalArgumentException::class.java) {
         Seasons().getSeason(n)
      }
      Assertions.assertEquals("Значение должно быть в пределах от 1 до 12: $n", exception.message)
   }
}