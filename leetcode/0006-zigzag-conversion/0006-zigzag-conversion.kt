class Solution {
    fun convert(s: String, numRows: Int): String {
        if(numRows == 1){
            return s
        }
        val mutableListOf = mutableListOf<String>()
        for (i in 0 until numRows) {
            mutableListOf.add("")
        }
        var index = 0;
        var reverse = false
        for (i in s) {
            if (!reverse) {
                mutableListOf[index] += i.toString()
                if (index < numRows - 1) {
                    index++
                } else {
                    reverse = true;
                    index--
                }
                continue
            } else {
                mutableListOf[index] += i.toString()
                if (index <= 0) {
                    index++
                    reverse = false
                } else {
                    index--
                }
            }
        }
        return mutableListOf.joinToString("")
    }
}