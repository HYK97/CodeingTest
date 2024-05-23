package leetcode

fun main() {
    val arraySpecial = Sol11().isArraySpecial(intArrayOf(4,3,1,6))
    println("arraySpecial = ${arraySpecial}")
}

class Sol11 {
    fun isArraySpecial(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return true
        }
        var one = 0
        var two = 1
        while (two < nums.size) {
            val oneParity = nums[one] % 2 == 0
            val twoParity = nums[two] % 2 == 0
            if (!(oneParity && !twoParity) && !(!oneParity && twoParity)) {
                return false
            }
            one++
            two++
        }
        return true
    }
}

//01 12 23 34 45