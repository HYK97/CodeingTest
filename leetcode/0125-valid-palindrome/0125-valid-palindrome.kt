 class Solution {
        fun isPalindrome(s: String): Boolean {
            var p1 = 0
            var p2 = s.length - 1
            while (p1 < p2) {
                var leftChar = s[p1]
                var rightChar = s[p2]
                if (!isAlpaAndNum(leftChar)) {
                    p1++
                    continue
                }
                if (!isAlpaAndNum(rightChar)) {
                    p2--
                    continue
                }
            
                if (leftChar.lowercaseChar() != rightChar.lowercaseChar()) {
                    return false
                }
                p1++
                p2--
            }
            return true
        }

        fun isAlpaAndNum(c: Char): Boolean {
            return (c in 'a'..'z') || (c in 'A'..'Z') || (c in '0'..'9')
        }
    }