import kotlin.math.max
import kotlin.math.min

data class Point(val x: Int, val y: Int)
data class Line(val start: Point, val end: Point)

fun isVertical(line: Line): Boolean {
    return line.start.x == line.end.x
}

fun isHorizontal(line: Line): Boolean {
    return line.start.y == line.end.y
}

fun overlappingPoints(lines: List<Line>): Int {
    val points = mutableSetOf<Point>()
    var overlappingPoints = mutableSetOf<Point>()
    for (line in lines) {
        for (point in path(line)) {
            if (!points.add(point)) {
                overlappingPoints.add(point)
            }
        }
    }
    return overlappingPoints.size
}

fun path(line: Line): List<Point> {
    if (isHorizontal(line)) {
        return horizontalPath(line)
    }
    if (isVertical(line)) {
        return verticalPath(line)
    }
    return emptyList()
}

fun horizontalPath(line: Line): List<Point> {
    val y = line.start.y
    val start = min(line.start.x, line.end.x)
    val end = max(line.start.x, line.end.x)
    return (start..end).map { x -> Point(x, y) }
}

fun verticalPath(line: Line): List<Point> {
    val x = line.start.x
    val start = min(line.start.y, line.end.y)
    val end = max(line.start.y, line.end.y)
    return (start..end).map { y -> Point(x, y) }
}

fun lines(input: List<String>): List<Line> {
    return input.map(::Line)
}

fun Line(input: String): Line {
    val points = input.split(" -> ").map(::Point)
    return Line(points.first(), points.last())
}

fun Point(input: String): Point {
    val pair = input.split(",").map(String::toInt)
    return Point(pair.first(), pair.last())
}