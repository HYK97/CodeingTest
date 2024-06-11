package leetcode

import java.util.LinkedList

fun main() {
    val testCase = arrayOf(
        "EEEEEEE",
        "ELELEEL",
        "ELEELEELLL"
    )
    for (s in testCase) {
        val minimumChairs = Sol23().minimumChairs(s)
        println("minimumChairs = ${minimumChairs}")
    }

}

class Sol23 {
    fun minimumChairs(s: String): Int {
        val linkedList = LinkedList<Byte>()
        var maxSize = -1
        for (c in s) {
            if (c == 'E') {
                linkedList.add(1)
            } else {
                linkedList.poll()
            }
            maxSize = maxSize.coerceAtLeast(linkedList.size)
        }
        return maxSize
    }
}