import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class TestSortedArray {

@ParameterizedTest
@MethodSource("sortedArray")
        fun testSortedArray(numbers: Array<Double>, result:  Array<Double>) {
        Assertions.assertArrayEquals(result, SortedArray().getSortedArray(numbers),"")
        }

    companion object {
        @JvmStatic
        fun sortedArray() = listOf(
            Arguments.of(arrayOf(1.0, 0.1, -1.0, -0.1, 0.0), arrayOf(-1.0, -0.1, 0.0, 0.1, 1.0))
        )
    }
}