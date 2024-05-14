import java.util.*

class Solution {
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