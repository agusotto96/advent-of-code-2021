import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day08 {

    private val input = File("src/test/resources/Day08.txt").readLines()

    @Test
    fun part1() {
        val entries = entries(input)
        val count = countUniqueSignalDigits(entries)
        assertEquals(26, count)
    }

    @Test
    fun part2() {
        val entries = entries(input)
        val count = entriesDigitsSum(entries)
        assertEquals(61229, count)
    }

}