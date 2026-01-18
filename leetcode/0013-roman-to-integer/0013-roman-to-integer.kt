class Solution {
    fun romanToInt(s: String): Int {
        var sum = 0
        val splits = s.split("")
        var prev = ""
        for (split in splits) {
            if (prev == "") {
                prev = split
                continue
            }
            val change = change(prev + split)
            if (change != 0) {
                sum += change
                prev = ""
            } else {
                sum += change(prev)
                prev = split
            }
        }
        return sum
    }

    fun change(s: String) = when (s) {
        "I" -> 1
        "IV" -> 4
        "V" -> 5
        "IX" -> 9
        "X" -> 10
        "XL" -> 40
        "L" -> 50
        "XC" -> 90
        "C" -> 100
        "CD" -> 400
        "D" -> 500
        "CM" -> 900
        "M" -> 1000
        else -> 0
    }
}