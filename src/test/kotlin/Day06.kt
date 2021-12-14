import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day06 {

    private val input = File("src/test/resources/Day06.txt")

    @Test
    fun part1() {
        val population = population(input)
        assertEquals(5934, simulateGrowth(population, 80))
    }

    @Test
    fun part2() {
        val population = population(input)
        assertEquals(26984457539, simulateGrowth(population, 256))
    }

}