package leetcode

import java.util.*

fun main() {
    val numberOfPairs = Sol16().numberOfPairs(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3), 2)
    println("numberOfPairs = ${numberOfPairs}")
}

class Sol16 {


    fun numberOfPairs(nums1: IntArray, nums2: IntArray, k: Int): Int {
        val divisorNum = nums2.map { i -> i * k }.toIntArray()
        var result = 0

        for (i in nums1) {
            for (j in divisorNum) {
                if (i % j == 0) {
                    result++
                }
            }
        }
        return result
    }
}