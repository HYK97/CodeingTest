class Solution {
    fun numSteps(s: String): Int {
        var count = 0
        var binary = s
        while (binary != "1") {
            count++
            if (binary.last() == '0') {
                binary = binary.dropLast(1)
            } else {
                val carry = binaryAdd(binary, "1")
                binary = carry
            }
        }
        return count
    }

    private fun binaryAdd(a: String, b: String): String {
        var carry = '0'
        val result = StringBuilder()
        var i = a.length - 1
        var j = b.length - 1
        while (i >= 0 || j >= 0) {
            val sum = (if (i >= 0) a[i].code - '0'.code else 0) +
                    (if (j >= 0) b[j].code - '0'.code else 0) +
                    (if (carry == '1') 1 else 0)
            result.append((sum % 2).digitToChar())
            carry = if (sum > 1) '1' else '0'
            i--
            j--
        }
        if (carry == '1') {
            result.append('1')
        }
        return result.reverse().toString()
    }
}