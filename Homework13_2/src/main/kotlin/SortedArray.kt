class SortedArray {
    fun getSortedArray(numbers: Array<Double>): Array<Double> {
        val result: Array<Double> = Array(numbers.size) {0.0}
        var p = numbers.size - 1
        var n = 0
        for (i in numbers) {
            if(i < 0) {
                result[n] = i
                n++
            }
            else{
                result[p] = i
                p--
            }
        }
        return result
    }
}