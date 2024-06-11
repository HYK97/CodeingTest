package leetcode

import kotlin.math.max

fun main() {
    Sol14()
        .maxScoreWords(
            arrayOf("xxxz", "ax", "bx", "cx"),
            charArrayOf('z', 'a', 'b', 'c', 'x', 'x', 'x'),
            intArrayOf(4, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10)
        )
}

class Sol14 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {

        val count = IntArray(26)
        val lettersCount = IntArray(26)

        for (c in letters) {
            count[c.code - 'a'.code]++
        }
        var ans = 0

        fun backtracking(
            pos: Int,
            temp: Int,
        ): Int {
            var temp = temp
            for (i in 0..25) {
                if (lettersCount[i] > count[i]) {
                    return ans
                }
            }

            ans = max(ans.toDouble(), temp.toDouble()).toInt()

            for (i in pos until words.size) {
                for (c in words[i].toCharArray()) {
                    lettersCount[c.code - 'a'.code]++
                    temp += score[c.code - 'a'.code]
                }

                ans = backtracking(i + 1, temp)

                for (c in words[i].toCharArray()) {
                    lettersCount[c.code - 'a'.code]--
                    temp -= score[c.code - 'a'.code]
                }
            }

            return ans
        }

        ans = backtracking(0, 0)
        return ans
    }

}
