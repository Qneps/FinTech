import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets
import java.util.*

class FioFaker() {
    private val gender = getGender()
    private val fioFileName = "fio.txt"

    private fun getGender(): String{
        return arrayOf("male", "female").random()
    }
    fun getGenderKir() =
            when (gender) {
                "male" -> "МУЖ"
                "female" -> "ЖЕН"
                else -> "ОНО"
            }


    fun getFirstName(): String {
        val fioMap = getFioMapFromFile(gender)
        return getNameList(fioMap, "firstname").random()
    }
    fun getLastName(): String {
        val fioMap = getFioMapFromFile(gender)
        return getNameList(fioMap, "lastname").random()
    }
    fun getMiddleName(): String {
        val fioMap = getFioMapFromFile(gender)
        return getNameList(fioMap, "middlename").random()
    }

    private fun getFioMapFromFile(gender: String): Map<String, String> {
        val lines = try {
            this::class.java.classLoader.getResourceAsStream(fioFileName).use { resource ->
                BufferedReader(InputStreamReader(resource!!, StandardCharsets.UTF_8)).lines().toList()
            }
        } catch (e: Exception) {
            throw IOException("Не удалось прочитать файл $fioFileName")
        }
        val fioMap = HashMap<String, String>()
        lines.map {
            it.split("=").run {
                fioMap[this[0]] = this[1]
            }
        }
        return fioMap.filter { it.key.startsWith(gender) }
    }

    private fun getNameList(fioMap: Map<String, String>, type: String) =
            fioMap.entries.first { it.key.contains(type, true) }.value.split(",")
}