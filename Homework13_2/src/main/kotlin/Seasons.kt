class Seasons {
    fun getSeason(n: Int): String {
        if(n in 1..12){
            if (n in 3..5)
                return "Spring"
            else if  (n in 6..8)
                return "Summer"
            else if(n in 9..11)
                return "Autumn"
            else
                return "Winter"
        }
        else
            throw IllegalArgumentException("Значение должно быть в пределах от 1 до 12: $n")
    }

}