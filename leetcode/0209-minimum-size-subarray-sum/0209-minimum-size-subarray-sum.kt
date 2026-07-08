class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val sumArray = mutableListOf<Int>()
        sumArray.add(0)
        for (num in nums.indices) {
            sumArray.add(sumArray[num] + nums[num])
        }
        var min = Int.MAX_VALUE
        for (i in sumArray.indices) {
            val left = sumArray[i]
            var binarySearch = sumArray.binarySearch(left + target)
            if (binarySearch < 0) {
                // 음수를 실제 '삽입 위치' 인덱스로 변환!
                binarySearch = -(binarySearch + 1)
            }
            // 찾은 인덱스가 배열 범위 안에 있는지 확인 (넘어가면 합이 target 안 된다는 뜻)
            if (binarySearch < sumArray.size) {
                min = minOf(min, binarySearch - i)
            }
        }
        if(Int.MAX_VALUE == min){
            return 0
        }
        return min
    }
}