package leetcode

fun main() {
    val sol = Sol34()
    val nums = intArrayOf(1, 2, 3, 4)
    val result = sol.productExceptSelf(nums)
    println(result.joinToString(", "))
}


class Sol34 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n) { 1 }

        for (i in 1 until n) {
            result[i] = result[i - 1] * nums[i - 1]
        }

        var right = 1
        for (i in n - 1 downTo 0) {
            result[i] *= right
            right *= nums[i]
        }

        return result
    }
}