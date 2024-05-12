class Solution {
  fun findPermutationDifference(s: String, t: String): Int {
        val sArray = s.toCharArray()
        val tArray = t.toCharArray()
        val map = HashMap<Char, Int>()
        for (c in sArray.withIndex()) {
            map[c.value] = c.index
        }
        var sum = 0
        for (index in tArray.indices) {
            val abs = map[sArray[index]]?.minus(map[tArray[index]]!!)?.let { abs(it) }
            sum += abs!!
        }

        return sum
    }
}