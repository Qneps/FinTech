import com.itextpdf.text.Document
import com.itextpdf.text.Font
import com.itextpdf.text.PageSize
import com.itextpdf.text.Paragraph
import com.itextpdf.text.pdf.BaseFont
import com.itextpdf.text.pdf.PdfPCell
import com.itextpdf.text.pdf.PdfPTable
import com.itextpdf.text.pdf.PdfWriter
import java.io.FileOutputStream


object Table {
        @JvmStatic
        fun main(args: Array<String>) {

            val document = Document(PageSize.A4.rotate())
            val baseFont = BaseFont.createFont("arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
            val font = Font(baseFont, 10f, Font.NORMAL)
            val colWidths = floatArrayOf(2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 2f, 1f, 1f)

            try {
                PdfWriter.getInstance(document,
                        FileOutputStream("Peoples.pdf"))
                document.open()

                val paragraph = Paragraph()
                val table = PdfPTable(colWidths) // столбцы

                for (i in 0..10) {
                    val user = UserGenerator().getUser()
                    for (key in user) {
                        val cell = PdfPCell(Paragraph(key.value, font))
                        table.addCell(cell)
                    }
                }

                paragraph.add(table)
                document.add(paragraph)


                document.close()
            } catch (e: Exception) {
                println(e)
            }
        }
    }