class Solution {
    fun getLastMoment(n: Int, left: IntArray, right: IntArray): Int {
        var max = 0
        for (i in left) {
            max = max.coerceAtLeast(i)
        }
        for (i in right) {
            max = max.coerceAtLeast(n - i)
        }
        return max
    }
}
