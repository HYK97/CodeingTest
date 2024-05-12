class Solution {
    fun maximumEnergy(energy: IntArray, k: Int): Int {
        val n = energy.size
        // 각 위치에서 시작했을 때의 최대 에너지를 저장할 배열
        val dp = IntArray(n) { 0 }
        // 뒤에서부터 계산
        for (i in n - 1 downTo 0) {
            dp[i] = energy[i] // 현재 위치의 에너지로 초기화
            // k만큼 떨어진 위치가 존재하는 경우, 그 위치의 최대 에너지를 현재 위치의 에너지에 더함
            if (i + k < n) {
                dp[i] += dp[i + k]
            }
        }
        // 가능한 모든 시작점 중 최대 에너지를 찾음
        return dp.maxOrNull() ?: 0
    }
}