class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val result = mutableListOf<Int>()
        if (matrix.isEmpty()) return result
        
        // 1. 네 개의 벽(경계선) 초기화
        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1
        
        // 2. 종료 조건: 벽이 서로 교차하기 전까지 계속 반복 
        // 더 쉬운 방법 matrix -> 개수랑 result 개수랑 같은때
        while (top <= bottom && left <= right) {
            
            // 오른쪽으로 이동 (맨 윗줄)
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++ // 윗벽을 한 칸 아래로 내림
            
            // 아래로 이동 (맨 오른쪽 줄)
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right-- 
            
            // 윗벽이 아랫벽(bottom)보다 커졌거나, 
            // 왼쪽벽이 오른쪽벽보다 커졌다면 더 이상 갈 곳이 없음
            if (top > bottom || left > right) break
            
            // 왼쪽으로 이동 (맨 아랫줄)
            for (i in right downTo left) {
                result.add(matrix[bottom][i])
            }
            bottom-- // 아랫벽을 한 칸 위로 올림
            
            // 위로 이동 (맨 왼쪽 줄)
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++ // 왼쪽 벽을 한 칸 오른쪽으로 당김
        }
        
        return result
    }
}