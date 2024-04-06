package programmers.impl

/*
* 누적합
* */
fun main() {
    파괴되지않은도시().solution(
        arrayOf(
            intArrayOf(5, 5, 5, 5, 5),
            intArrayOf(5, 5, 5, 5, 5),
            intArrayOf(5, 5, 5, 5, 5),
            intArrayOf(5, 5, 5, 5, 5)
        ),
        arrayOf(
            intArrayOf(1, 0, 0, 3, 4, 4),
            intArrayOf(1, 2, 0, 2, 3, 2),
            intArrayOf(2, 1, 0, 3, 1, 2),
            intArrayOf(1, 0, 1, 3, 3, 1)
        )
    )
}

class 파괴되지않은도시 {
    fun solution(board: Array<IntArray>, skill: Array<IntArray>): Int {
        val row = board.size
        val col = board[0].size

        val newBoard = Array(row) { i -> IntArray(col) { j -> 0 } }
        for (sk in skill) {
            val type = sk[0]
            val r1 = sk[1]
            val c1 = sk[2]
            val r2 = sk[3]
            val c2 = sk[4]
            val degree = sk[5]
            if (type == 2) {
                newBoard[r1][c1] += degree
                if (c2 + 1 < col) {
                    newBoard[r1][c2 + 1] += -degree
                }
                if (r2 + 1 < row) {
                    newBoard[r2 + 1][c1] += -degree
                }
                if (r2 + 1 < row && c2 + 1 < col) {
                    newBoard[r2 + 1][c2 + 1] += degree
                }
            } else {
                newBoard[r1][c1] += -degree
                if (c2 + 1 < col) {
                    newBoard[r1][c2 + 1] += degree
                }
                if (r2 + 1 < row) {
                    newBoard[r2 + 1][c1] += degree
                }
                if (r2 + 1 < row && c2 + 1 < col) {
                    newBoard[r2 + 1][c2 + 1] += -degree
                }
            }
        }

        for (c in newBoard[0].indices) {
            var prev = 0
            for (r in newBoard.indices) {
                newBoard[r][c] += prev
                prev = newBoard[r][c]
            }
        }

        var count = 0
        for (r in newBoard.indices) {
            var prev = 0
            for (c in newBoard[0].indices) {
                newBoard[r][c] += prev
                prev = newBoard[r][c]
                if (board[r][c] + newBoard[r][c] > 0) {
                    count++
                }
            }
        }

        return count
    }
}