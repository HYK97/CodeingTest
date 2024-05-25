class Solution {
    fun wordBreak(s: String, wordDict: List<String>): List<String> {
        val array = s.chunked(1)
        val result= mutableListOf<String>()
        val dicSet = HashSet<String>(wordDict)
        fun backtracking(count: Int, tmp: String) {

            if (count == s.length) {
                val trim = tmp.trim()
                result.add(trim)
                return
            }
            for (i in count+1 .. array.size) {
                val word = s.substring(count, i)
                if (dicSet.contains(word)) {
                    var tmpWord = tmp
                    tmpWord += " $word"
                    backtracking(i,tmpWord)
                }
            }
        }
        backtracking(0, "")
        return result
    }
}