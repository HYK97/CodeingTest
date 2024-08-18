package leetcode

import kotlin.math.max

class Sol40 {
    fun mergeAlternately(word1: String, word2: String): String {
        val word1s = word1.toCharArray()
        val word2s = word2.toCharArray()
        var mergeData =""
        val max = max(word1s.size, word2s.size)
        for (i in 0 until max) {
            if (i < word1s.size) {
                mergeData += word1s[i]
            }
            if (i < word2s.size) {
                mergeData += word2s[i]
            }
        }
        return mergeData
    }
}
