fun depths(input: List<String>): List<Int> {
    return input.map(String::toInt)
}

fun depths(input: List<String>, windowSize: Int): List<Int> {
    return depths(input).windowed(windowSize).map(List<Int>::sum)
}

fun depthIncrease(depths: List<Int>): Int {
    var increased = 0
    var lastDepth: Int? = null
    for (depth in depths) {
        if (lastDepth != null && lastDepth < depth) {
            increased++
        }
        lastDepth = depth
    }
    return increased
}