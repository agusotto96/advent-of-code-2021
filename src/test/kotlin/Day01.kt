import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day01 {

    private val input = File("src/test/resources/Day01.txt").readLines()

    @Test
    fun part1() {
        val depths = depths(input)
        val depthIncrease = depthIncrease(depths)
        assertEquals(7, depthIncrease)
    }

    @Test
    fun part2() {
        val depths = depths(input, 3)
        val depthIncrease = depthIncrease(depths)
        assertEquals(5, depthIncrease)
    }

}