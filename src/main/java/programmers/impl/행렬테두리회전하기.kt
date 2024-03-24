package programmers.impl

fun main() {
    Solution().solution(100, 97, arrayOf(intArrayOf(1,1,100,97)))
}

class Solution {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val answer = ArrayList<Int>()
        val dx = arrayOf(0, 1, 0, -1)
        val dy = arrayOf(1, 0, -1, 0)
        val map = Array(rows + 1, { IntArray(columns + 1, { 0 }) })
        var id = 1
        for (row in 1 until map.size) {
            for (column in 1 until  map[0].size) {
                map[row][column] = id
                id++
            }
        }

        for (queryInfo in queries.withIndex()) {
            val query = queryInfo.value
            val startRow = query[0]
            val startColum = query[1]
            val endRow = query[2]
            val endColum = query[3]
            var prevData = map[startRow][startColum]
            var currentRow = query[0]
            var currentColum = query[1]
            var d = 0
            var min = prevData
            while (true) {
                if (dx[d] + currentRow > endRow || dy[d] + currentColum > endColum || dx[d] + currentRow < startRow || dy[d] + currentColum < startColum ) {
                    d++;
                }
                currentRow += dx[d]
                currentColum += dy[d]
                val tmp = map[currentRow][currentColum]
                min = Math.min(min,tmp)
                map[currentRow][currentColum] = prevData
                prevData = tmp
                if (currentRow == startRow && currentColum == startColum) {
                    break;
                }
            }
            answer.add(min)

        }

        return answer.toIntArray()
    }
}


//리팩버전
class Solution2 {
    fun solution(rows: Int, columns: Int, queries: Array<IntArray>): IntArray {
        val minValues = mutableListOf<Int>()
        val matrix = Array(rows + 1) { IntArray(columns + 1) { 0 } }
        var number = 1

        for (row in 1..rows) {
            for (col in 1..columns) {
                matrix[row][col] = number++
            }
        }

        for (query in queries) {
            val (startRow, startColumn, endRow, endColumn) = query
            var currentRow = startRow
            var currentColumn = startColumn
            var prevValue = matrix[currentRow][currentColumn]
            var minValue = prevValue
            val directionChanges = arrayOf(0 to 1, 1 to 0, 0 to -1, -1 to 0) // 방향 변화 (오른쪽, 아래, 왼쪽, 위)
            var directionIndex = 0

            while (true) {
                val (dx, dy) = directionChanges[directionIndex]
                val nextRow = currentRow + dx
                val nextColumn = currentColumn + dy

                if (nextRow !in startRow..endRow || nextColumn !in startColumn..endColumn) {
                    directionIndex = (directionIndex + 1) % 4
                    if (directionIndex == 0) break // 모든 방향을 검사한 후 원점에 도달하면 종료

                } else {
                    currentRow = nextRow
                    currentColumn = nextColumn
                    val temp = matrix[currentRow][currentColumn]
                    minValue = minOf(minValue, temp)
                    matrix[currentRow][currentColumn] = prevValue
                    prevValue = temp
                }
            }

            minValues.add(minValue)
        }

        return minValues.toIntArray()
    }
}