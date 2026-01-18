class Solution {
    fun intToRoman(num: Int): String {
        var temp = num
        var result = ""

        while (temp > 0) {
            println(temp)
            when {
                1000 <= temp -> {
                    val repeat = (temp / 1000) % 10
                    temp -= 1000 * repeat
                    result += "M".repeat(repeat)
                }

                900 <= temp -> {
                    temp -= 900
                    result += "CM"
                }

                500 <= temp -> {
                    temp -= 500
                    result += "D"
                }

                400 <= temp -> {
                    temp -= 400
                    result += "CD"
                }

                100 <= temp -> {
                    val repeat = (temp / 100) % 10
                    temp -= 100 * repeat
                    result += "C".repeat(repeat)
                }

                90 <= temp -> {
                    temp -= 90
                    result += "XC"
                }

                50 <= temp -> {
                    temp -= 50
                    result += "L"
                }

                40 <= temp -> {
                    temp -= 40
                    result += "XL"
                }

                10 <= temp -> {
                    val repeat = (temp / 10) % 10
                    temp -= 10 * repeat
                    result += "X".repeat(repeat)
                }

                9 <= temp -> {
                    temp -= 9
                    result += "IX"
                }

                5 <= temp -> {
                    temp -= 5
                    result += "V"
                }

                4 <= temp -> {
                    temp -= 4
                    result += "IV"
                }

                else -> {
                    result += "I".repeat(temp)
                    temp -= temp
                }
            }
        }
        return result
    }
}
