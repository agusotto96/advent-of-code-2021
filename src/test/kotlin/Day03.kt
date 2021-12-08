import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day03 {

    private val input = File("src/test/resources/Day03.txt").readLines()

    @Test
    fun part1() {
        val powerConsumption = powerConsumption(input)
        assertEquals(powerConsumption, 198)
    }

    @Test
    fun part2() {
        val lifeSupportRating = lifeSupportRating(input)
        assertEquals(lifeSupportRating, 230)
    }


}