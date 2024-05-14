package leetcode

import java.util.*

fun main() {
    // 예시 1
    val quality1 = intArrayOf(10, 20, 5)
    val wage1 = intArrayOf(70, 50, 30)
    val k1 = 2
    println(Sol1().mincostToHireWorkers(quality1, wage1, k1)) // 출력: 105.0

    // 예시 2
    val quality2 = intArrayOf(3, 1, 10, 10, 1)
    val wage2 = intArrayOf(4, 8, 2, 2, 7)
    val k2 = 3
    println(Sol1().mincostToHireWorkers(quality2, wage2, k2)) // 출력: 30.66667
}

class Sol1 {

    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        // quality와 wage 배열, 그리고 k 값을 받아서 최소 비용을 계산하는 함수
        val ratios = quality.mapIndexed { index, q -> wage[index].toDouble() / q to q }
            .sortedBy { it.first }
        // ratios 리스트를 생성하고 비율(wage/quality) 기준으로 오름차순 정렬

        var qualitySum = ratios.take(k).sumOf { it.second }
        // 앞의 k개 비율에 대한 quality 값의 합 계산
        var maxRate = ratios.take(k).maxOf { it.first }
        // 앞의 k개 비율 중 최댓값 계산
        var res = maxRate * qualitySum
        // 초기 res 값 계산 (maxRate * qualitySum)

        val maxHeap = PriorityQueue<Int>(k, reverseOrder())
        // 크기가 k이고 내림차순으로 정렬되는 maxHeap 생성
        ratios.take(k).forEach { maxHeap.offer(it.second) }
        // 앞의 k개 비율에 대한 quality 값을 maxHeap에 추가

        for (i in k until ratios.size) {
            // k번째부터 ratios의 마지막 인덱스까지 반복
            maxRate = maxOf(maxRate, ratios[i].first)
            // maxRate를 현재 maxRate와 ratios[i]의 비율 중 최댓값으로 업데이트
            qualitySum += ratios[i].second - maxHeap.poll()
            // qualitySum에 ratios[i]의 quality 값을 더하고, maxHeap에서 가장 큰 값을 제거
            maxHeap.offer(ratios[i].second)
            // ratios[i]의 quality 값을 maxHeap에 추가
            res = minOf(res, maxRate * qualitySum)
            // res를 현재 res와 maxRate * qualitySum의 최솟값으로 업데이트
        }
        return res
        // 최종 res 값 반환
    }
}
