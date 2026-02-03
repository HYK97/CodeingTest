class Solution {
    // 배열을 전치 시킨이후에 배열 뒤집기
    fun rotate(matrix: Array<IntArray>): Unit {
        for (i in matrix.indices) {
            for (j in 0 until i) { // 중요 절반만 실행
                val tmp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = tmp
            }
        }

        for (i in matrix.indices) {
            matrix[i].reverse()
        }
    }
}