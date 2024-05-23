package leetcode

import java.util.*
import kotlin.math.min


fun main() {
    val maximumSafenessFactor = Sol8().maximumSafenessFactor(
        listOf(
            listOf(0, 0, 0, 1),
            listOf(0, 0, 0, 0),
            listOf(0, 0, 0, 0),
            listOf(1, 0, 0, 0),
        )
    )
    println("maximumSafenessFactor = ${maximumSafenessFactor}")
}
class Sol8 {
    fun maximumSafenessFactor(grid: List<List<Int>>): Int {
        val N: Int = grid.size
        val dyx = arrayOf(intArrayOf(1, 0), intArrayOf(0, 1), intArrayOf(-1, 0), intArrayOf(0, -1))


        // 1단계: -1로 안전 매트릭스 초기화
        val safetyDistances = Array(N) { IntArray(N) }
        for (row in safetyDistances) {
            Arrays.fill(row, -1)
        }


        // 2단계: BFS 초기화
        val bfsQueue: Queue<IntArray> = LinkedList()
        for (row in 0 until N) {
            for (col in 0 until N) {
                if (grid[row][col] === 1) {
                    bfsQueue.add(intArrayOf(row, col, 0))
                    safetyDistances[row][col] = 0
                }
            }
        }


        // 3단계: BFS를 수행하여 안전 거리 계산 -> 도둑으로 부터의 거리 메트릭스 계산
        while (!bfsQueue.isEmpty()) {
            val cell = bfsQueue.poll()
            val row = cell[0]
            val col = cell[1]
            val dist = cell[2]
            for (direction in dyx) {
                val newRow = row + direction[0]
                val newCol = col + direction[1]
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || safetyDistances[newRow][newCol] != -1) {
                    continue
                }
                safetyDistances[newRow][newCol] = dist + 1
                bfsQueue.add(intArrayOf(newRow, newCol, dist + 1))
            }
        }

        val visited = Array(N) { BooleanArray(N) }
        val maxHeap = PriorityQueue { a: IntArray, b: IntArray -> b[0].compareTo(a[0])
        }
        maxHeap.add(intArrayOf(safetyDistances[0][0], 0, 0))


        // 4단계: 우선순위 큐를 사용하여 최대 안전 경로 찾기 -> 다익스트라 계산 (최소거리 구하기) 힙을 이용해서 지나간 거리에서 안전계수가 큰순서대로 정렬 -> 마지막에 도착하면 Poll해서 반환 -> 최대 안전계수 구하기 성공
        while (!maxHeap.isEmpty()) {
            val cell = maxHeap.poll()
            val currentSafeness = cell[0]
            val row = cell[1]
            val col = cell[2]
            if (row == N - 1 && col == N - 1) {
                return currentSafeness
            }
            if (visited[row][col]) {
                continue
            }
            visited[row][col] = true
            for (direction in dyx) {
                val newRow = row + direction[0]
                val newCol = col + direction[1]
                if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N || visited[newRow][newCol]) {
                    continue
                }
                maxHeap.add(
                    intArrayOf(
                        min(currentSafeness.toDouble(), safetyDistances[newRow][newCol].toDouble())
                            .toInt(), newRow, newCol
                    )
                )
            }
        }

        return -1
    }
}