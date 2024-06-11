class Solution {
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