class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var col = false
        var row = false
        for (i in matrix.indices){
            if(matrix[i][0] == 0){
                col = true
            }
        }
        for (i in matrix[0].indices){
            if(matrix[0][i] == 0){
                row = true
            }
        }

        for (i in 1 until matrix.size){
            for (j in 1 until matrix[0].size){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0
                    matrix[0][j] = 0
                }
            }
        }
        

        for (i in 1 until matrix.size){
            if(matrix[i][0] == 0){
                for(j in matrix[i].indices){
                    matrix[i][j] = 0
                }
            }
        }

        for (i in 1 until matrix[0].size){
            if(matrix[0][i] == 0){
                for(j in matrix.indices){
                    matrix[j][i] = 0
                }
            }
        }
        

        if (col){
            for (i in matrix.indices){
                matrix[i][0] = 0
            }
        }

        if (row){
            for (i in matrix[0].indices){
                matrix[0][i] =0
            }
        }

    }
}