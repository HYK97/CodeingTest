class Solution {
    // two sum 으로 만들기
    // a + b + c = 0  => a + b = -c <= -c 고정 a,b는 정렬후에 검색 (-c 고정 n 번 , a,b 포인터 n 번 총 n제곱)

    fun threeSum(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        nums.sort()
        for (i in nums.indices) {
            var p1 = i + 1
            var p2 = nums.size - 1
            if (i > 0 && nums[i] == nums[i-1]) {
                continue
            }
            while (p1 < p2) {
                val sum = nums[p1] + nums[p2] + nums[i]
                if (sum == 0) {
                    result.add(listOf(nums[p1], nums[p2], nums[i]))                   
                    while (p1 < p2 && nums[p1 + 1] == nums[p1]) {
                        p1++
                    }
                    while (p1 < p2 && nums[p2 - 1] == nums[p2]) {
                        p2--
                    }
                    p1++
                    p2--
                }
                if (sum > 0) {
                    p2--
                    continue
                }
                if (sum < 0) {
                    p1++
                    continue
                }
            }
        }
        return result
    }
}