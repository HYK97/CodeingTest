package leetcode

import kotlin.math.abs

fun main() {
    val arraySpecial = Sol12().isArraySpecial2(intArrayOf(4, 3, 1, 6), arrayOf(intArrayOf(0, 2), intArrayOf(2, 3)))
    println(arraySpecial.contentToString())
}


class Sol12 {
    fun isArraySpecial(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val array = BooleanArray(nums.size) { true }
        val result = BooleanArray(queries.size) { true }
        if (nums.size == 1) {
            return result
        }
        var one = 0
        var two = 1
        while (two < nums.size) {
            val oneParity = nums[one] % 2 == 0
            val twoParity = nums[two] % 2 == 0
            if (!(oneParity && !twoParity) && !(!oneParity && twoParity)) {
                array[one] = false
            }
            one++
            two++
        }

        for (query in queries.withIndex()) {
            val first = query.value[0]
            val second = query.value[1]
            for (i in first until second) {
                if (!array[i]) {
                    result[query.index] = false
                }
            }
        }
        return result
    }

    fun isArraySpecial2(nums: IntArray, queries: Array<IntArray>): BooleanArray {
        val n = nums.size
        val oddPrefixSum = IntArray(n + 1)
        val evenPrefixSum = IntArray(n + 1)

        // 홀수, 짝수 개수의 누적 합 계산
        for (i in 1..n) {
            oddPrefixSum[i] = oddPrefixSum[i - 1] + if (nums[i - 1] % 2 != 0) 1 else 0
            evenPrefixSum[i] = evenPrefixSum[i - 1] + if (nums[i - 1] % 2 == 0) 1 else 0
        }

        val result = BooleanArray(queries.size)
        for ((index, query) in queries.withIndex()) {
            val (from, to) = query
            // 구간 내 홀수, 짝수 개수 계산
            val oddCount = oddPrefixSum[to + 1] - oddPrefixSum[from]
            val evenCount = evenPrefixSum[to + 1] - evenPrefixSum[from]

            // 구간 내 홀수와 짝수 개수의 차이가 1 이하이고, 시작과 끝 원소의 홀짝성이 다른 경우에만 특수 배열로 판단
            result[index] = abs(oddCount - evenCount) <= 1 && (nums[from] % 2 != nums[to] % 2)
        }

        return result
    }
}