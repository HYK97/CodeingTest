class Solution {
    fun longestCommonPrefix(strs: Array<String>): String {
        var result = ""
        val min = strs.minOfOrNull { it.length } ?: 0

        for (i in 0 until min) {
            var targetAlp = ' '
            var flag = true
            for (s in strs) {
                if (targetAlp == ' ') {
                    targetAlp = s[i]
                    continue;
                }
                if (targetAlp != s[i]) {
                    flag = false
                    break
                }
            }
            if (flag) {
                result += targetAlp
            } else {
                break
            }
        }
        return result
    }
}