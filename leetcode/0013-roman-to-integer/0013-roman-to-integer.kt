class Solution {
    fun romanToInt(s: String): Int {
        var sum = 0
        val length = s.length
        for (i in 0 until length) {
            val currentVal = getValue(s[i])
            if (i < length - 1 && currentVal < getValue(s[i + 1])) {
                sum -= currentVal
            } else {
                sum += currentVal
            }
        }
        return sum
    }

    fun getValue(c: Char) = when (c) {
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}