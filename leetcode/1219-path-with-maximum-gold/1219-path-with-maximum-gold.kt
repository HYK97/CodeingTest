class Solution {
 fun getMaximumGold(grid: Array<IntArray>): Int {

        val dx = intArrayOf(1, 0, -1, 0)
        val dy = intArrayOf(0, 1, 0, -1)
        val maxX = grid.size
        val maxY = grid[0].size
        fun dfs(x: Int, y: Int): Int {
            if (x >= maxX || y >= maxY || x < 0 || y < 0 || grid[x][y] == 0) {
                return 0
            }
            var max = 0

            val originalVal = grid[x][y]

            grid[x][y] = 0

            for (i in 0 until 4) {
                max = maxOf(
                    max,
                    dfs(
                        dx[i] + x,
                        dy[i] + y
                    )
                )
            }
            grid[x][y] = originalVal
            return max + originalVal
        }

        var max = 0
        for (ints in grid.indices) {
            for (int in grid[0].indices) {
                max = maxOf(max, dfs(ints, int));
            }
        }
        return max
    }
}