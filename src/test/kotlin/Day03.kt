import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day03 {

    private val input = File("src/test/resources/Day03.txt").readLines()

    @Test
    fun part1() {
        val powerConsumption = powerConsumption(input)
        assertEquals(198, powerConsumption)
    }

    @Test
    fun part2() {
        val lifeSupportRating = lifeSupportRating(input)
        assertEquals(230, lifeSupportRating)
    }


}