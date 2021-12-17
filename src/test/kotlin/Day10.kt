import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day10 {

    private val input = File("src/test/resources/Day10.txt")

    @Test
    fun part1() {
        assertEquals(26397, fileCorruptedScore(input))
    }

    @Test
    fun part2() {
        assertEquals(288957, fileUnclosedScore(input))
    }

}