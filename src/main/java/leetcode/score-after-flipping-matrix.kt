package leetcode

fun main() {
    val matrixScore =
        Sol6().matrixScore(arrayOf(intArrayOf(0, 0, 1, 1), intArrayOf(1, 0, 1, 0), intArrayOf(1, 1, 0, 0)))
    println(matrixScore)
}

class Sol6 {
    fun matrixScore(grid: Array<IntArray>): Int {
        for (ints in grid.withIndex()) {
            val original = ints.value.joinToString("")
            val originalInt = original.toInt(2)
            val reverse = invertBinaryString(original)
            val reverseInt = reverse.toInt(2)
            if (originalInt > reverseInt) {
                continue
            }
            if (reverseInt > originalInt) {
                grid[ints.index] = reverse.chunked(1).map { it.toInt() }.toIntArray()
            }
        }


        for (row in grid[0].withIndex()) {
            var original = ""
            for (col in grid.withIndex()) {
                original += grid[col.index][row.index].toString()
            }

            val originalInt = original.count { it == '1' }
            val reverse = invertBinaryString(original)
            val reverseInt = reverse.count { it == '1' }
            if (originalInt > reverseInt) {
                continue
            }

            if (reverseInt > originalInt) {
                val toIntArray = reverse.chunked(1).map { it.toInt() }.toIntArray()
                for (col in grid.withIndex()) {
                    grid[col.index][row.index] = toIntArray[col.index]
                }
            }

        }

        var sum = 0
        for (ints in grid) {
            sum += ints.joinToString("").toInt(2)
        }
        return sum
    }

    fun invertBinaryString(binary: String): String {
        val sb = StringBuilder(binary.length)
        for (char in binary) {
            sb.append(if (char == '0') '1' else '0')
        }
        return sb.toString()
    }
}