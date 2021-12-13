fun entries(input: List<String>): List<Entry> {
    return input.map(::Entry)
}

fun Entry(input: String): Entry {
    val splitInput = input.split(" | ")
    val patterns = splitInput.first().split(" ").map(String::toSet).map(::Pattern)
    val digits = splitInput.last().split(" ").map(String::toSet).map(::Pattern)
    return Entry(patterns, digits)
}

val uniqueSegments = setOf(2, 4, 3, 7)

fun countUniqueSignalDigits(entries: List<Entry>): Int {
    return entries.flatMap(Entry::digits).map(Pattern::size).count(uniqueSegments::contains)
}

data class Entry(val patterns: List<Pattern>, val digits: List<Pattern>)

fun entriesDigitsSum(entries: List<Entry>): Int {
    return entries.map(::entryDigits).sum()
}

fun entryDigits(entry: Entry): Int {
    val digitsByPattern = digitsByPattern(entry.patterns)
    return entry.digits.map(digitsByPattern::getValue).joinToString("", transform = Int::toString).toInt()
}

fun digitsByPattern(patterns: List<Pattern>): Map<Pattern, Int> {
    val patternsBySize = patterns.groupBy(Pattern::size)
    val one = patternsBySize.getValue(2).first()
    val four = patternsBySize.getValue(4).first()
    val seven = patternsBySize.getValue(3).first()
    val eight = patternsBySize.getValue(7).first()
    val twoThreeFive = patternsBySize.getValue(5)
    val zeroSixNine = patternsBySize.getValue(6)
    val three = twoThreeFive.first { it.contains(one) }
    val nine = zeroSixNine.first { (it - three).size() == 1 }
    val six = (zeroSixNine - nine).first { a -> (twoThreeFive - three).any { b -> (a - b).size() == 1 } }
    val five = (twoThreeFive - three).first { (six - it).size() == 1 }
    val two = (twoThreeFive - three - five).first()
    val zero = (zeroSixNine - six - nine).first()
    return mapOf(
        zero to 0, one to 1, two to 2, three to 3, four to 4,
        five to 5, six to 6, seven to 7, eight to 8, nine to 9
    )
}

data class Pattern(val signals: Set<Char>) {
    fun size() = signals.size
    fun contains(other: Pattern) = signals.containsAll(other.signals)
    operator fun minus(other: Pattern) = Pattern(signals - other.signals)
}

