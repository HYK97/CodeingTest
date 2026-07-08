
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var p1 = 0
        var p2 = 0
        var maxSize = 0
        var set = mutableSetOf<Char>()
        while (p2 <= s.length - 1) {
            val head = s[p2]
            if (!set.contains(head)) {
                set.add(head)
                p2++
            } else {
                maxSize = Math.max(maxSize, p2 - p1)
                while(s[p2] != s[p1] && p1 < p2){
                    set.remove(s[p1])
                    p1++
                }
                if(s[p2] == s[p1] && p1 < p2){
                    set.remove(s[p1])
                    p1++
                }
            }
        }
        return Math.max(maxSize, p2 - p1)
    }
}