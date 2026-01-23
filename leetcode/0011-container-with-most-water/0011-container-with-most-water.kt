// 양쪽에서 시작 계산해서 max값 갱신
// 단 벽이 작은쪽이 움직이는 식으로 진행
class Solution {
    fun maxArea(height: IntArray): Int {
        var maxSize = 0
        var p1 = 0
        var p2 = height.size - 1
        while(p1 < p2){
            var left = height[p1]
            var right = height[p2]
            var currentHeight = Math.min(left,right)
            var currentSize = currentHeight * (p2-p1)
            maxSize = Math.max(maxSize,currentSize)
            if(left>right){
                p2--
            } else{
                p1++
            }            
        }
        return maxSize
    }
}