fun instructions(input: List<String>): List<Pair<String, Int>> {
    return input.map { it.split(' ') }.map { it[0] to it[1].toInt() }
}

fun simpleCourse(instructions: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depth = 0
    for (instruction in instructions) {
        when (instruction.first) {
            "forward" -> horizontalPosition += instruction.second
            "down" -> depth += instruction.second
            "up" -> depth -= instruction.second
        }
    }
    return horizontalPosition * depth
}

fun complexCourse(instructions: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0
    for (instruction in instructions) {
        when (instruction.first) {
            "forward" -> {
                horizontalPosition += instruction.second
                depth += instruction.second * aim
            }
            "down" -> aim += instruction.second
            "up" -> aim -= instruction.second
        }
    }
    return horizontalPosition * depth
}
