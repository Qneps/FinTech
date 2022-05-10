class Seasons {
    fun getSeason(n: Int): String {
        if(n in 1..12){
            val season: String
            if (n in 3..5)
                season = "Spring"
            else if  (n in 6..8)
                season = "Summer"
            else if(n in 9..11)
                season = "Autumn"
            else
                season = "Winter"
            println(season)
            return season
        }
        else
            throw IllegalArgumentException("Значение должно быть в пределах от 1 до 12: $n")
    }

}