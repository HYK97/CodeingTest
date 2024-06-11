package leetcode

import java.util.*

fun main() {

}

class Sol25 {
    fun heightChecker(heights: IntArray): Int {
        val original = heights.copyOf()
        Arrays.sort(heights)
        var count = 0
        for (index in original.indices) {
            if (original[index] != heights[index]) {
                count++
            }
        }
        return count
    }
}


