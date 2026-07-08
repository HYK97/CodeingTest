package leetcode.code75

fun main() {
    val reverseWords = Sol1().reverseWords("a good   example")
    println("reverseWords = ${reverseWords}")
}

class Sol1 {
    fun reverseWords(s: String): String {
        val replaceSpace = replaceSpace(s)
        replaceSpace.reverse()
        val joinToString = replaceSpace.joinToString(" ")
        return joinToString
    }

    private fun replaceSpace(s: String): MutableList<String> {
        val split = s.split(" ")
        val replaceList = split
            .asSequence()
            .filter { it != "" }
            .toMutableList()
        return replaceList
    }
}