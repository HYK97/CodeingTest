class Solution {
   fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        val priorityQueue = PriorityQueue<Int>(Comparator.reverseOrder())
           for (data in happiness) {
            priorityQueue.add(data)
        }
        var sum: Long = 0
        for ((happinessDecremented) in (0 until k).withIndex()) {
            val i = priorityQueue.poll() - happinessDecremented
            if (i < 0) {
                continue
            }
            sum += i
        }
        return sum
    }
}