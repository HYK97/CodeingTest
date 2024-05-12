class Solution {
 fun largestLocal(grid: Array<IntArray>): Array<IntArray> {
        val n = grid.size
        val size = n - 2
        val result = Array(size) { IntArray(size) { 0 } }
        for (i in 0 until size) {
            for (j in 0 until size) {
                var max = 0
                for (k in 0 until 3) {
                    for (l in 0 until 3) {
                        max = maxOf(max, grid[i + k][j + l])
                    }
                }
                result[i][j] = max
            }
        }
        return result
    }
}