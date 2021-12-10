import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day04 {

    private val input = File("src/test/resources/Day04.txt").readLines()

    @Test
    fun part1() {
        val bingo = Bingo(input)
        val score = findFirstWinnerScore(bingo)
        assertEquals(4512, score)
    }

    @Test
    fun part2() {
        val bingo = Bingo(input)
        val score = findLastWinnerScore(bingo)
        assertEquals(1924, score)
    }

}