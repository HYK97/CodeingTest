class Solution {
    fun reverseWords(s: String): String {
        val result = StringBuilder()
        val replace = s.trim().replace("\\s+".toRegex(), " ")
        var data = ""
        for (i in replace) {
            if (i != ' ') {
                data += i
            } else {
                result.insert(0," "+data)
                data = ""
            }
        }
        if (data.isNotEmpty()){
            result.insert(0, data)
        }
        return result.toString()
    }
}