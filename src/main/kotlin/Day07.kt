import kotlin.math.abs

fun positions(input: String): List<Int> {
    return input.split(",").map(String::toInt)
}

fun median(positions: List<Int>): Int {
    return positions.sorted()[positions.size / 2]
}

fun fuelSpent(positions: List<Int>): Int {
    val median = median(positions)
    return positions.sumOf { abs(it - median) }
}