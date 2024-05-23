package leetcode

import java.util.*

fun main() {
    val maximumGold = Sol7().getMaximumGold(
        arrayOf(
            intArrayOf(1, 0, 7),
            intArrayOf(2, 0, 6),
            intArrayOf(3, 4, 5),
            intArrayOf(0, 3, 0),
            intArrayOf(9, 0, 20),
        )
    )
    println("maximumGold = ${maximumGold}")
    val maximumGold1 = Sol7().getMaximumGold(
        arrayOf(
            intArrayOf(0, 6, 0),
            intArrayOf(5, 8, 7),
            intArrayOf(0, 9, 0),

            )
    )
    println("maximumGold1 = ${maximumGold1}")
    val maximumGold2 = Sol7().getMaximumGold(
        arrayOf(
            intArrayOf(1, 0, 7, 0, 0, 0),
            intArrayOf(2, 0, 6, 0, 1, 0),
            intArrayOf(3, 5, 6, 7, 4, 2),
            intArrayOf(4, 3, 1, 0, 2, 0),
            intArrayOf(3, 0, 5, 0, 20, 0),

            )
    )
    println("maximumGold1 = ${maximumGold2}")
}


class Sol7 {

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

    //실패코드
    fun getMaximumGold2(grid: Array<IntArray>): Int {


        var max = Int.MIN_VALUE
        for (ints in grid.withIndex()) {
            for (int in ints.value.withIndex()) {
                val queue = LinkedList<Pair<Int, Int>>()
                val visited = Array(grid.size) { IntArray(grid[0].size) { 0 } }
                val dx = intArrayOf(1, 0, -1, 0)
                val dy = intArrayOf(0, 1, 0, -1)
                val maxX = grid.size
                val maxY = grid[0].size
                if (grid[ints.index][int.index] > 0 && visited[ints.index][int.index] == 0) {
                    queue.add(Pair(ints.index, int.index))
                    visited[ints.index][int.index] = grid[ints.index][int.index]

                    while (!queue.isEmpty()) {
                        val poll = queue.poll()
                        val x = poll.first
                        val y = poll.second
                        for (i in 0 until 4) {
                            val newX = x + dx[i]
                            val newY = y + dy[i]
                            if (newX >= maxX || newY >= maxY || newX < 0 || newY < 0) {
                                continue
                            }
                            if (visited[newX][newY] != 0) { //이미 체크한애들
                                continue
                            }
                            if (grid[newX][newY] == 0) { // 0인애들
                                continue
                            }
                            val data = visited[x][y] + grid[newX][newY]
                            queue.add(Pair(newX, newY))
                            max = maxOf(max, data)
                            visited[newX][newY] = data
                        }
                    }
                }
                println(visited.contentDeepToString())
            }
        }
        return max
    }
}