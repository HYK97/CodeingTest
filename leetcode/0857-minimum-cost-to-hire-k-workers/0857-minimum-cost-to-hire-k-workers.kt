class Solution {
    fun mincostToHireWorkers(quality: IntArray, wage: IntArray, k: Int): Double {
        val ratios = quality.mapIndexed { index, q -> wage[index].toDouble() / q to q }
            .sortedBy { it.first }

        var qualitySum = ratios.take(k).sumOf { it.second }
        var maxRate = ratios.take(k).maxOf { it.first }
        var result = maxRate * qualitySum

        val maxHeap = PriorityQueue<Int>(k, reverseOrder())
        ratios.take(k).forEach { maxHeap.offer(it.second) }

        for (i in k until ratios.size) {
            maxRate = maxOf(maxRate, ratios[i].first)
            qualitySum += ratios[i].second - maxHeap.poll()
            maxHeap.offer(ratios[i].second)
            result = minOf(result, maxRate * qualitySum)
        }
        return result
    }
}




