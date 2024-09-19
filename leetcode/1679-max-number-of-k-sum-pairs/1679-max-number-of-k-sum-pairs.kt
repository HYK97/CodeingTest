class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var left = 0
        var right = nums.size - 1
        var result=0
        while (left < right) {
            val compareK = nums[left] + nums[right]
            if (compareK > k) {
                right--
            } else if (compareK < k) {
                left++
            } else {
                left++
                right--
                result++
            }
        }
        return result
    }
}
