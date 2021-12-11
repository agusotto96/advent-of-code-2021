import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day07 {

    private val input = File("src/test/resources/Day07.txt").readText()

    @Test
    fun part1() {
        val positions = positions(input)
        val fuelSpent = fuelSpent(positions)
        assertEquals(37, fuelSpent)
    }

}