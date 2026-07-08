package leetcode.code75

fun main() {

}

class Sol2 {
    fun increasingTriplet(nums: IntArray): Boolean {
        var first: Int = Int.MAX_VALUE
        var second: Int = Int.MAX_VALUE
        for (num in nums) {
            if (num <= first) { // 기존에 업데이트한 first값보다 작은경우 재 업데이트
                first = num
            } else if (num <= second) { // 자동으로 first보다 크면서 second보다 작거나같은 값을 다시 업데이트
                second = num
            } else { // second보다 큰값이 존재한다는것은 3번의 증가하는 subsequence가 있다는 의
                return true
            }
        }
        return false
    }
}