package leetcode

fun main() {
    Sol29().sortColors(intArrayOf(2,0,2,1,1,0))
}

class Sol29 {
    fun sortColors(nums: IntArray): Unit {
        val countingSort = intArrayOf(0, 0, 0)
        for (i in nums) {
            countingSort[i]++
        }
        var index=0
        for (i in countingSort.withIndex()) {
            for (i1 in 1..i.value) {
                nums[index++]=i.index
            }
        }
    }
}