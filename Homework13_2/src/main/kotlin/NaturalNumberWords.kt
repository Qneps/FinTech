import com.ibm.icu.text.RuleBasedNumberFormat
import java.util.*

class NaturalNumberWords {
    fun getNaturalNumberWords(n: Int): String{
        if(n in 1..1000){
            val nf = RuleBasedNumberFormat(
                Locale.forLanguageTag("ru"),
                RuleBasedNumberFormat.SPELLOUT
            )
            val result = nf.format(n)
            println(result)
            return result
        }
        else
            throw IllegalArgumentException("Значение должно быть в пределах от 1 до 1000: $n")
    }
}