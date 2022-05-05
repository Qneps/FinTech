import com.github.javafaker.Faker
import com.itextpdf.text.*
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*


object Table {
    @JvmStatic
    fun main(args: Array<String>) {
        val faker = Faker(Locale("RU"))
        val country = faker.address().country() //Страна
        val cityName = faker.address().cityName() // Город
        val city = faker.address().city() // Место рождения
        val secondaryAddress = faker.address().secondaryAddress() // номер Квартиры
        val streetAddressNumber = faker.address().streetAddressNumber() // Номер Дома
        val streetName = faker.address().streetName() // Улица
        val zipCode = faker.address().zipCode() // Индекс
        val fio = FioFaker() // Пол
        val firstName = fio.getFirstName() // Имя
        val middleName = fio.getMiddleName() //Отчество
        val lastName = fio.getLastName() // Фамилия
        val userAge = UserAge() // Возраст
        val birthday: Date = faker.date().birthday(); // Дата Рождения
        val now  = Date()
        val age: Int = userAge.getDiffYears(birthday, now)
        val dateFormat = SimpleDateFormat("dd-MM-yyyy");
        val document = Document(PageSize.A4.rotate())
        val baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
        val font = Font(baseFont, 10f, Font.NORMAL)
        try {
            PdfWriter.getInstance(document,
                    FileOutputStream("Peoples.pdf"))
            document.open()


            val paragraph = Paragraph()
            val table = PdfPTable(14) // столбцы
            val cell1 = PdfPCell(Paragraph(firstName, font)) // Имя
            val cell2 = PdfPCell(Paragraph(lastName, font))  // Фамилия
            val cell3 = PdfPCell(Paragraph(middleName, font)) // Отчество
            val cell4 = PdfPCell(Paragraph("Cell 3")) // Возраст
            val cell5 = PdfPCell(Paragraph("Cell 3")) // Пол
            val cell6 = PdfPCell(Paragraph(dateFormat.format(birthday))) // Дата рождения
            val cell7 = PdfPCell(Paragraph(city)) // Место рождения
            val cell8 = PdfPCell(Paragraph(zipCode)) // Индекс
            val cell9 = PdfPCell(Paragraph(country)) // Страна
            val cell10 = PdfPCell(Paragraph("Cell 3")) // Область
            val cell11 = PdfPCell(Paragraph(cityName)) // Город
            val cell12 = PdfPCell(Paragraph(streetName)) // Улица
            val cell13 = PdfPCell(Paragraph(streetAddressNumber)) // Дом
            val cell14 = PdfPCell(Paragraph(secondaryAddress)) // Квартира

            table.addCell(cell1)
            table.addCell(cell2)
            table.addCell(cell3)
            table.addCell(cell4)
            table.addCell(cell5)
            table.addCell(cell6)
            table.addCell(cell7)
            table.addCell(cell8)
            table.addCell(cell9)
            table.addCell(cell10)
            table.addCell(cell11)
            table.addCell(cell12)
            table.addCell(cell13)
            table.addCell(cell14)

            paragraph.add(table)
            document.add(paragraph)

            
            document.close()
        } catch (e: Exception) {
            println(e)
        }
    }
}