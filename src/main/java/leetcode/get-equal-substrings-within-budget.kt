package leetcode

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val equalSubstring = Sol19().equalSubstring("abcd", "acde", 0)
    println("equalSubstring = ${equalSubstring}")
}

class Sol19 {
    fun equalSubstring(s: String, t: String, maxCost: Int): Int {
        val sChunk = s.toCharArray()
        val tChunk = t.toCharArray()
        val N: Int = s.length

        var maxLen = 0

        var start = 0

        var currCost = 0

        for (i in 0 until N) {
            currCost += abs(sChunk[i] - tChunk[i])

            while (currCost > maxCost) {
                currCost -= abs(sChunk[start] - tChunk[start])
                start++
            }

            maxLen = max(maxLen.toDouble(), (i - start + 1).toDouble()).toInt()
        }

        return maxLen
    }

}
