class Solution {
    fun compress(chars: CharArray): Int {
        var left = 0
        var right = 0
        var res = 0
        while (right < chars.size) {
            while (right < chars.size && chars[right] == chars[left]) { //같은 문자열일때만 right 늘림
                right++
            }
            chars[res++] = chars[left]// index 점프
            val count = right - left
            if(count > 1) {
                for (i in count.toString()) {
                    chars[res++] = i
                }
            }
            left = right
        }
        return res
    }
}