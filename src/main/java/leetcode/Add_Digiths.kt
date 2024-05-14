package leetcode

import java.util.*

fun main() {

    println( Add_Digiths().addDigits( 0))
}

class Add_Digiths {
    fun addDigits(num: Int): Int {
        val queue = LinkedList(num.toString().map { it.toString() })
        while (queue.size != 1) {
            val first = queue.poll()
            val second = queue.poll()
            val sum = first.toInt() + second.toInt()
            val split = sum.toString().map { it.toString() }
            for (s in split) {
                queue.add(s)
            }
        }
        return queue.poll().toInt()
    }
}