class Solution {
    fun lengthOfLastWord(s: String): Int {
        var count = 0
        var start = true
        for(i in s.length-1 downTo 0){
            if(s[i]==' ' && start){
                continue
            }
            if(s[i]!=' '){
                count++
                start=false
                continue
            }
            if(s[i]==' ' && !start){
                break
            }
        }
        return count
    }
}