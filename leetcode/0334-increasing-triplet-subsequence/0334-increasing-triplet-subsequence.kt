class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        var queue = LinkedList<Int>()
        for (num in nums) {
            if (queue.isEmpty()) {
                queue.addLast(num)
            }
            if (queue.peekLast() < num) {
                queue.addLast(num)
            }
            if (queue.peekLast() > num) {
                queue.pollLast()
                queue.addLast(num)
                cleanQueue(queue)
            }
        }
        return queue.size >= 3
    }

    private fun cleanQueue(queue: LinkedList<Int>) {
        while (queue.size >= 2) {
            val last = queue.pollLast()
            if (queue.peekLast() > last) {
                queue.pollLast()
                queue.addLast(last)
            } else {
                queue.addLast(last)
                break
            }
        }
    }
}