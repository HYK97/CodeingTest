package leetcode

import java.util.LinkedList
import java.util.Queue

class Sol33 {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        val maxLeft = left.maxOrNull() ?: 0
        val maxRight = right.maxOfOrNull { i -> n - i } ?: 0
        return maxOf(maxLeft, maxRight)
    }
}
