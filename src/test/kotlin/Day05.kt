import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day05 {

    private val input = File("src/test/resources/Day05.txt").readLines()

    @Test
    fun part1() {
        val lines = lines(input)
        val overlappingPoints = overlappingPoints(lines)
        assertEquals(5, overlappingPoints)
    }

    @Test
    fun part2() {
        val lines = lines(input)
        val overlappingPoints = overlappingPoints(lines, diagonal = true)
        assertEquals(12, overlappingPoints)
    }

}