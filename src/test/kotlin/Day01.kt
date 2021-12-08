import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day01 {

    private val input = File("src/test/resources/Day01.txt").readLines()

    @Test
    fun part1() {
        val depths = depths(input)
        val depthIncrease = depthIncrease(depths)
        assertEquals(depthIncrease, 7)
    }

    @Test
    fun part2() {
        val depths = depths(input, 3)
        val depthIncrease = depthIncrease(depths)
        assertEquals(depthIncrease, 5)
    }

}