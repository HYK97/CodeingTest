package leetcode

import java.util.*


class Sol27 {
    fun removeKdigits(num: String, k: Int): String {
        var queue = LinkedList<Int>()
        var deleteCount = k
        for (c in num) {
            val digit = c - '0'
            while (queue.isNotEmpty() && digit < queue.peekLast() && deleteCount > 0) {
                queue.pollLast()
                deleteCount--
            }
            queue.addLast(digit)
        }
        if (deleteCount > 0) {
            while (queue.isNotEmpty() && deleteCount > 0) {
                queue.pollLast()
                deleteCount--
            }
        }
        var result = ""
        for (i in queue.withIndex()) {
            if (result.first() == '0' || result.isBlank()) {
                continue
            }
            result += i.value
        }
        if (result === "") {
            return "0"
        }
        return result
    }
}