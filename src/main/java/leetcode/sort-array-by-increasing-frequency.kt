package leetcode

import java.util.*


internal class Sol36 {
    fun frequencySort(nums: IntArray): IntArray {
        val count = nums.toList().groupingBy { it }.eachCount()
        return nums.sortedWith(compareBy({ count[it] }, { -it })).toIntArray()
    }
}
