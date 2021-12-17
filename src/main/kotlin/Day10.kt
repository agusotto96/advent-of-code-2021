import java.io.File

fun close(open: Char): Char? {
    return when (open) {
        '(' -> ')'
        '[' -> ']'
        '{' -> '}'
        '<' -> '>'
        else -> null
    }
}

fun score(close: Char): Int? {
    return when (close) {
        ')' -> 3
        ']' -> 57
        '}' -> 1197
        '>' -> 25137
        '(' -> 1
        '[' -> 2
        '{' -> 3
        '<' -> 4
        else -> null
    }
}

fun fileCorruptedScore(file: File): Int {
    return file.readLines()
        .map(String::toList)
        .mapNotNull(::firstIllegalChar)
        .mapNotNull(::score)
        .sum()
}

fun fileUnclosedScore(file: File): Long {
    val lines = file.readLines()
    val scores = lines
        .asSequence()
        .map(String::toList)
        .filterNot(::isCorrupted)
        .map(::unclosedCharsScore)
        .sorted()
        .toList()
    return scores[scores.size / 2]
}

val closeChars = setOf(')', ']', '}', '>')

fun isCorrupted(line: List<Char>): Boolean {
    return firstIllegalChar(line) != null
}

fun unclosedChars(line: List<Char>): List<Char> {
    val chars = mutableListOf<Char>()
    for (char in line) {
        if (char in closeChars) {
            chars.removeLast()
        } else {
            chars.add(char)
        }
    }
    return chars
}

fun unclosedCharsScore(line: List<Char>): Long {
    var score = 0L
    for (char in unclosedChars(line).reversed()) {
        score *= 5
        score += score(char) ?: 0
    }
    return score
}

fun firstIllegalChar(line: List<Char>): Char? {
    val chars = mutableListOf<Char>()
    for (char in line) {
        if (char in closeChars) {
            if (char != close(chars.last())) {
                return char
            }
            chars.removeLast()
        } else {
            chars.add(char)
        }
    }
    return null
}