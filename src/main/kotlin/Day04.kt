typealias Board = List<MutableSet<Int>>

fun Bingo(input: List<String>): Bingo {
    val numbers = input.first().split(",").map(String::toInt)
    val boards = input.asSequence()
        .drop(1)
        .filter(String::isNotBlank)
        .map { it.split(" ").filter(String::isNotBlank).map(String::toInt) }
        .chunked(5)
        .map(::board)
        .toList()
    return Bingo(numbers, boards)
}

class Bingo(val numbers: List<Int>, val boards: List<Board>)

fun board(numbers: List<List<Int>>): Board {
    val board = mutableListOf<MutableSet<Int>>()
    for (x in numbers.indices) {
        val row = mutableSetOf<Int>()
        val column = mutableSetOf<Int>()
        for (y in numbers.indices) {
            row.add(numbers[x][y])
            column.add(numbers[y][x])
        }
        board.add(row)
        board.add(column)
    }
    return board
}

fun findWinnerScore(bingo: Bingo): Int? {
    for (number in bingo.numbers) {
        for (board in bingo.boards) {
            var isWinner = false
            for (group in board) {
                group.remove(number)
                if (group.isEmpty()) {
                    isWinner = true
                }
            }
            if (isWinner) {
                return score(number, board)
            }
        }
    }
    return null
}

fun score(number: Int, board: Board): Int {
    return number * board.flatten().toSet().sum()
}