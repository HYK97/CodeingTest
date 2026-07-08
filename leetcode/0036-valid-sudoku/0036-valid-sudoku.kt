class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // 가로 및 세로 검증
        for (i in 0 until 9) {
            val rows = mutableSetOf<Char>()
            val columns = mutableSetOf<Char>()
            for (j in 0 until 9) {
                if (!check(board[i][j], rows)) {
                    return false
                }
                if (!check(board[j][i], columns)) {
                    return false
                }
            }
        }
        for (a in 0..6 step 3) {
            for (b in 0..6 step 3) {
                val cube = mutableSetOf<Char>()                
                for (i in 0 until 3) {
                    for (j in 0 until 3) {
                        if (!check(board[i + a][j + b], cube)) {
                            return false
                        }
                    }
                }
            }
        }
        return true
    }
}

fun check(element: Char, set: MutableSet<Char>): Boolean {
    if (element == '.') {
        return true
    }
    if (set.contains(element)) {
        return false
    }
    set.add(element)
    return true
}
