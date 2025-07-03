class Solution {
    fun kthCharacter(k: Int): Char {
        val sb = StringBuilder("a")
        while (sb.length < k) {
            val size = sb.length
            for (i in 0 until size) {
                sb.append(nextAlphabet(sb[i]))
            }
        }
        return sb[k - 1]
    }

    private fun nextAlphabet(alp: Char): Char {
        return when (alp) {
            'z' -> 'a'
            else -> (alp.code + 1).toChar()
        }
    }
}