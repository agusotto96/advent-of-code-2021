fun simulateGrowth(initialAges: List<Int>, days: Int): Int {
    val ages = initialAges.toMutableList()
    repeat(days) {
        var births = 0
        for (index in ages.indices) {
            if (ages[index] == 0) {
                ages[index] = 6
                births++
            } else {
                ages[index]--
            }
        }
        repeat(births) { ages.add(8) }
    }
    return ages.count()
}

fun ages(input: String): List<Int> {
    return input.split(",").map(String::toInt)
}