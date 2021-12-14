import java.io.File

typealias Heightmap = List<List<Int>>

fun heightmap(file: File): Heightmap {
    return file.readLines().map { it.map(Char::digitToInt) }
}

fun lowestHeightsRiskLevel(heightmap: Heightmap): Int {
    val lowestHeights = lowestHeights(heightmap)
    return lowestHeights.map(::riskLevel).sum()
}

fun lowestHeights(heightmap: Heightmap): List<Int> {
    val lowestHeights = mutableListOf<Int>()
    for (i in heightmap.indices) {
        for (j in heightmap.first().indices) {
            val height = heightmap[i][j]
            val up = heightmap.getOrNull(i - 1)?.getOrNull(j)
            val down = heightmap.getOrNull(i + 1)?.getOrNull(j)
            val left = heightmap.getOrNull(i)?.getOrNull(j - 1)
            val right = heightmap.getOrNull(i)?.getOrNull(j + 1)
            val adjacentHeights = setOfNotNull(up, down, left, right)
            val lowestAdjacentHeight = adjacentHeights.minOrNull()
            if (lowestAdjacentHeight != null && height < lowestAdjacentHeight) {
                lowestHeights.add(height)
            }
        }
    }
    return lowestHeights
}

fun riskLevel(height: Int): Int {
    return height + 1
}