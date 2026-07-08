class Solution {
    fun isSubsequence(s: String, t: String): Boolean {
        var p1 = 0
        var p2 = 0
        if(s.isEmpty()){
            return true
        }
        while(p2 < t.length  && p1 < s.length){
            var target=s[p1]
            var compare = t[p2]
            if(target != compare){
                p2++
                continue
            }
            if(target == compare && p1 == s.length - 1){
                return true
            }
            if(target == compare){
                p1++
                p2++
            }
            
        }
        return false
    }
}