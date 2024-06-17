class Solution {
    fun rob(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 0 }
        dp[0] = nums[0]
        if (nums.size > 1) {
            dp[1] = maxOf(nums[0], nums[1])
        }
        for (i in 2 until nums.size) {
            dp[i] = maxOf(dp[i - 1], nums[i] + dp[i - 2])
        }
        return dp.last()
    }
}
//2 7 100 3 1 100