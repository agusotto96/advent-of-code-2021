import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day06 {

    private val input = File("src/test/resources/Day06.txt").readText()

    @Test
    fun part1() {
        val population = population(input)
        val simulateGrowth = simulateGrowth(population, 80)
        assertEquals(5934, simulateGrowth)
    }

    @Test
    fun part2() {
        val population = population(input)
        val simulateGrowth = simulateGrowth(population, 256)
        assertEquals(26984457539, simulateGrowth)
    }

}