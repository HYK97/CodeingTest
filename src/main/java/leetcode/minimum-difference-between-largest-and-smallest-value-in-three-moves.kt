package leetcode

import kotlin.math.min

fun main() {
    val minDifference = Sol30().minDifference(intArrayOf(1,2,3,4,5,6,7,8,9,10))
}

class Sol30 {
    fun minDifference(nums: IntArray): Int {
        val numsSize = nums.size

        if (numsSize <= 4) {
            return 0
        }

        nums.sort()

        var minDiff = Int.MAX_VALUE

        var left = 0
        var right = numsSize - 4
        while (left < 4) {
            minDiff = min(minDiff.toDouble(), (nums[right] - nums[left]).toDouble()).toInt()
            println(left)
            println(right)
            println("nums[left] = ${nums[left]}")
            println("nums[right] = ${nums[right]}")
            left++
            right++
        }

        return minDiff
    }
}
