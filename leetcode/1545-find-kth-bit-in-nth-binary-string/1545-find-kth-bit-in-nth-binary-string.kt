class Solution {
    fun findKthBit(n: Int, k: Int): Char {
        var sArray = Array(20) { "0" }
        for (i in 1..<20) {
            sArray[i] = sArray[i-1] + "1" + invert(sArray[i - 1]).reversed()
        }
        return sArray[n - 1].toCharArray()[k - 1]
    }

    private fun invert(data: String): String {
        return data
            .map { if (it == '1') '0' else '1' }
            .joinToString("")
    }
}