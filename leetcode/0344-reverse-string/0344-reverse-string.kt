class Solution {
    fun reverseString(s: CharArray): Unit {
        var start =0
        var end = s.size - 1
        while (start < end) {
            var tmp: Char
            tmp = s[start]
            s[start] = s[end]
            s[end] = tmp
            start++
            end--
        }
    }
}