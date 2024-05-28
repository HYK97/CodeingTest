class Solution {
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