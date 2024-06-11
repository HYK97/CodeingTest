class Solution {
      private fun binarySearch(nums: IntArray, value: Int): Int {
        var start = 0
        var end = nums.size - 1
        var index = nums.size
        while (start <= end) {
            val mid = (start + end) / 2
            if (nums[mid] >= value) {
                index = mid
                end = mid - 1
            } else {
                start = mid + 1
            }
        }
        return index
    }

    fun specialArray(nums: IntArray): Int {
        nums.sort()

        val N = nums.size
        for (x in 1..N) {
            val k = binarySearch(nums, x)
            if (N - k == x) {
                return x
            }
        }

        return -1
    }
}