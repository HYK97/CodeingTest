class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var start = 0
        var end = 0
        var zeroCount = 0

        while (end < nums.size) {
            if (nums[end] === 0) {
                zeroCount++
            }
            end++
            if (zeroCount > k) {
                if (nums[start] === 0) {
                    zeroCount--
                }
                start++
            }
        }
        return end - start
    }
}