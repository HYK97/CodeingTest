class Solution {
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
            left++
            right++
        }

        return minDiff
    }
}