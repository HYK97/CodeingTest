package leetcode

fun main() {
    val compressedString = Sol17().compressedString("aaaaaaaaaaaaaabb")
    println("compressedString = ${compressedString}")
}

class Sol17 {
    fun compressedString(word: String): String {
        var comp = ""
        var prev = ""
        var count = 0
        for (c in word.chunked(1)) {
            if ((prev != "" && prev != c) || count == 9) {
                comp += "$count$prev"
                count = 0
            }
            prev = c
            count++
        }
        comp += "$count$prev"
        return comp
    }
}