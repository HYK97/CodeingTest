class Solution {
    fun strStr(haystack: String, needle: String): Int {
        val needleHashCode = needle.hashCode()
        var i = 0;
        var j = needle.length;
        while (j <= haystack.length) {
            val substring = haystack.substring(i, j)
            if (needleHashCode == substring.hashCode()) {
                var flag = true
                for (k in needle.indices) {
                    if (needle[k] != substring[k]) {
                        flag = false
                    }
                }
                if (flag) {
                    return i
                }
            } else {
                i++
                j++
            }
        }
        return -1
    }
}