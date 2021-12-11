import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day07 {

    private val input = File("src/test/resources/Day07.txt").readText()

    @Test
    fun part1() {
        val positions = positions(input)
        val fuelCost = bestPositionFuelCost(positions, ::constantFuelCost)
        assertEquals(37, fuelCost)
    }

    @Test
    fun part2() {
        val positions = positions(input)
        val fuelCost = bestPositionFuelCost(positions, ::incrementalFuelCost)
        assertEquals(168, fuelCost)
    }

}