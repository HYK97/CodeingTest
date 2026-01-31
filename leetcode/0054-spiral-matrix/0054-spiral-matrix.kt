class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var maxR = matrix[0].size - 1
        var maxT = matrix.size - 1
        var maxL = 0
        var maxB = 0
        var result = mutableListOf<Int>()
        val count = matrix.size * matrix[0].size
        while(result.size!=count) {
            right(matrix, maxR, maxT, maxL, maxB,result)
            maxR--
            if(result.size==count){
                return result
            }
            down(matrix, maxR, maxT, maxL, maxB,result)
            maxB++
            if(result.size==count){
                return result
            }
            left(matrix, maxR, maxT, maxL, maxB,result)
            maxL++
            if(result.size==count){
                return result
            }
            up(matrix, maxR, maxT, maxL, maxB,result)
            maxT--
        }
        return result
    }
}
fun right(matrix: Array<IntArray>, maxR: Int ,maxT: Int ,maxL: Int, maxB: Int, result: MutableList<Int>){
    for(i in maxL .. maxR){
        result.add(matrix[maxB][i])
    }
}
fun down(matrix: Array<IntArray>, maxR: Int ,maxT: Int ,maxL: Int, maxB: Int, result: MutableList<Int>){
    for(i in maxB+1 .. maxT) {
        result.add(matrix[i][maxR+1])
    }
}
fun left(matrix: Array<IntArray>, maxR: Int ,maxT: Int ,maxL: Int, maxB: Int, result: MutableList<Int>){
    for(i in maxR downTo maxL) {
        result.add(matrix[maxT][i])
    }
}
fun up(matrix: Array<IntArray>, maxR: Int ,maxT: Int ,maxL: Int, maxB: Int, result: MutableList<Int>){
    for(i in maxT-1 downTo maxB) {
        result.add(matrix[i][maxL-1])
    }
}