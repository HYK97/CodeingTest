class Solution {
    fun maxArea(height: IntArray): Int {
        var maxArea = -1

        // 높이 결정
        var left = 0
        var right = height.size - 1
        //밑변
        var base = height.size - 1
        while (left != right) {
            val minHeight = min(height[left], height[right])
            val area = minHeight * base
            maxArea = max(maxArea, area)
            if (height[left] < height[right]) {
                left++
            } else {
                right--
            }
            base--
        }
        return maxArea
    }
}