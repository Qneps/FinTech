import com.github.javafaker.Faker
import java.text.SimpleDateFormat
import java.util.*

class UserGenerator {
    fun getUser(): Map<String, String> {
        val faker = Faker(Locale("RU"))
        val now  = Date()
        val fio = FioFaker() // ФИО + пол
        val userAge = DiffYears() // Возраст
        val dateFormat = SimpleDateFormat("dd-MM-yyyy") // Форматирование даты
        val birthday: Date =  faker.date().birthday() // Дата Рождения
        return mapOf(
            "firstname" to fio.getFirstName(), // Имя
            "lastName" to fio.getLastName(), // Фамилия
            "middleName" to fio.getMiddleName(), //Отчество
            "age" to userAge.getDiffYears(birthday, now).toString(), //Возраст
            "gender" to "male", //Пол
            "birthDay" to dateFormat.format(birthday), // // Дата Рождения
            "placeOfBirth" to faker.address().city(), // Место рождения
            "zipCode" to faker.address().zipCode(), // Индекс
            "country" to faker.address().country(), //Страна
            "area" to "",
            "city" to faker.address().cityName(), // Город
            "street" to faker.address().streetName(), // Улица
            "house" to faker.address().streetAddressNumber(), // Номер Дома
            "apartment" to faker.address().secondaryAddress() // номер Квартиры
        )
    }
}