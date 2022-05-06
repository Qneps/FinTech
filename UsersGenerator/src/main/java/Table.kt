import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.PageSize
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream
import java.net.URL
import java.nio.file.Paths
import java.util.*


object Table {
        @JvmStatic
        fun main(args: Array<String>) {
            val fileName = "Peoples.pdf"
            val reader = Scanner(System.`in`)
            print("Введите количество пользователей: ")
            try {
                val n: Int = reader.nextInt()
                if(n !in 1..30){
                    throw IllegalArgumentException("Значение должно быть в пределах от 1 до 30: " +
                            "$n")
                }
                val document = Document(PageSize.A4.rotate(),0f, 0f, 20f, 0f)
                val baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
                val font = Font(baseFont, 7f, Font.NORMAL)
                val columnWidths = floatArrayOf(3f, 4f, 5f, 3f, 3f, 4f, 5f, 3f, 5f, 7f, 5f, 6f, 3f, 3f)
                PdfWriter.getInstance(document,
                        FileOutputStream(fileName))
                document.open()

                val paragraph = Paragraph()
                val table = PdfPTable(columnWidths)
                table.setWidthPercentage(95f);
                var userData: Map<String, String>
                for (i in 0..n) {
                    userData = UserGenerator().getUser()
                    if (i == 0) {
                        for (user in userData) {
                            val cell = PdfPCell(Paragraph(user.key, font))
                            table.addCell(cell)
                        }
                    } else {
                        for (user in userData) {
                            val cell = PdfPCell(Paragraph(user.value, font))
                            table.addCell(cell)
                        }
                    }
                }

                paragraph.add(table)
                document.add(paragraph)


                document.close()
                val resource: URL = FioFaker::class.java.getResource("")
                var path = Paths.get(resource.toURI()).toAbsolutePath().toString()
                path = path.substring(0, path.length - 14) + fileName
                println("Файл создан. Путь:$path")
                // Простите за костыль, это лучшее, что я смог сделать, изучая Kotlin и java всего 2 недели :)
            } catch (e: Exception) {
                println(e)
            }
        }
    }