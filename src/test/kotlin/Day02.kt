import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class Day02 {

    private val input = File("src/test/resources/Day02.txt").readLines()

    @Test
    fun part1() {
        val instructions = instructions(input)
        val course = simpleCourse(instructions)
        assertEquals(course, 150)
    }

    @Test
    fun part2() {
        val instructions = instructions(input)
        val course = complexCourse(instructions)
        assertEquals(course, 900)
    }

}