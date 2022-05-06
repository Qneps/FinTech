import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import java.util.*

class UserGenerator {
    fun getUser(): Map<String, String> {
        val faker = Faker(Locale("RU"))
        val now  = Date()
        val fio = FioFaker()
        val userAge = DiffYears()
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val birthday: Date =  faker.date().birthday()
        return mapOf(
                "Имя" to fio.getFirstName(),
                "Фамилия" to fio.getLastName(),
                "Отчество" to fio.getMiddleName(),
                "Возраст" to userAge.getDiffYears(birthday, now).toString(),
                "Пол" to fio.getGenderKir(),
                "Дата рождения" to dateFormat.format(birthday),
                "Место рождения" to faker.address().city(),
                "Индекс" to faker.address().zipCode(),
                "Страна" to faker.address().country(),
                "Область" to faker.address().state(),
                "Город" to faker.address().cityName(),
                "Улица" to faker.address().streetName(),
                "Дом" to faker.address().streetAddressNumber(),
                "Квартира" to faker.address().secondaryAddress()
        )
    }
}