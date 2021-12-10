import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day06 {

    private val input = File("src/test/resources/Day06.txt").readText()

    @Test
    fun part1() {
        val ages = ages(input)
        val simulateGrowth = simulateGrowth(ages, 80)
        assertEquals(5934, simulateGrowth)
    }

}