package leetcode

import java.util.*
import java.util.stream.IntStream

class Sol32 {
    fun buildArray(target: IntArray, n: Int): List<String> {
        val result = mutableListOf<String>()
        var targetIndex = 0

        for (i in 1..n) {
            if (targetIndex >= target.size) {
                break
            }
            if (target[targetIndex] == i) {
                result.add("Push")
                targetIndex++
            } else {
                result.add("Push")
                result.add("Pop")
            }
        }
        return result
    }
}