import java.util.*

class UserAge {
    fun getCalendar(date: Date?): Calendar {
        val cal = Calendar.getInstance(Locale.US)
        cal.time = date
        return cal
    }
    fun getDiffYears(first: Date?, last: Date?): Int {
        val a = getCalendar(first)
        val b = getCalendar(last)
        var diff = b[Calendar.YEAR] - a[Calendar.YEAR]
        if (a[Calendar.MONTH] > b[Calendar.MONTH]
                || a[Calendar.MONTH] == b[Calendar.MONTH] && a[Calendar.DATE] > b[Calendar.DATE]) {
            diff--
        }
        return diff
    }
}