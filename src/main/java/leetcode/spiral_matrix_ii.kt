package leetcode

fun main() {
    val solution = Solution()
    val generateMatrix = solution.generateMatrix(3)
    for (generateMatrix1 in generateMatrix) {
        for (i in generateMatrix1) {
            print("$i ")
        }
        println()
    }
}

class Solution {

    fun generateMatrix(n: Int): Array<IntArray> {
        var count = 1
        val map = Array(n) { IntArray(n) { 0 } }
        var nRepeat =n
        var i = 0
        var j = 0
        while (nRepeat>1) {
            for (repeat in 1 until nRepeat) {
                map[j][i]= count++
                i++
            }
            for (repeat in 1 until nRepeat) {
                map[j][i]= count++
                j++
            }
            for (repeat in 1 until nRepeat) {
                map[j][i]= count++
                i--
            }
            for (repeat in 1 until nRepeat) {
                map[j][i]= count++
                j--
            }
            nRepeat -= 2
            i++
            j++
        }
        if (nRepeat == 1) {
            map[i][j] = count
        }
        return map
    }


}