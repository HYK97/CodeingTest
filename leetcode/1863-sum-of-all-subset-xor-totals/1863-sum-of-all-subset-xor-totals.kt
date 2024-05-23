class Solution {
    var sum = 0
    fun subsetXORSum(nums: IntArray): Int {
        dfs(0, 0, nums)
        return sum
    }
    fun dfs(index: Int, xor: Int, nums: IntArray) {
        sum += xor
        for (i in index until nums.size) {
            dfs(i + 1, xor xor nums[i],nums)
        }
    }
}