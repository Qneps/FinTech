class Seasons {
    fun getSeason(n: Int): String {
        if(n in 1..12){
            val season = if (n in 3..5)
                            "Spring"
                        else if  (n in 6..8)
                            "Summer"
                        else if(n in 9..11)
                            "Autumn"
                        else
                            "Winter"
            println(season)
            return season
        }
        else
            throw IllegalArgumentException("Значение должно быть в пределах от 1 до 12: $n")
    }

}