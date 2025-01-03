class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var zero = LinkedList<Int>()
        var start = 0
        var end = 0
        var max = 0
        while (end < nums.size) {
            if (nums[end] == 0) {
                zero.addLast(end)
            }
            end++
            if (zero.size >= 2) {
                start = zero.pollFirst() + 1
                continue
            }
            max = max(max, end - start)
        }
        return max - 1
    }
}