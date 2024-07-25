class Solution {
    fun pivotIndex(nums: IntArray): Int {
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        var leftPrefix = 0
        var rightPrefix = 0
        for (i in nums.indices) {
            left.add(nums[i] + leftPrefix)
            right.add(nums[nums.size - 1 - i] + rightPrefix)
            leftPrefix += nums[i]
            rightPrefix += nums[nums.size - 1 - i]
        }
        right.reverse()
        println("left. = ${left}")
        println("left. = ${right}")
        for (index in left.indices) {
            if (left[index] == right[index]) {
                return index
            }
        }
        return -1
    }
}