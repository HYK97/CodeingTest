class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        var p1 = 0
        var p2 = numbers.size - 1 
        while (p1 <= p2){
            val sum = numbers[p1] + numbers[p2]
            if (target < sum){
                p2--
                continue
            }
            if (target > sum){
                p1++
                continue
            }
            if(target == sum){
                return intArrayOf(p1+1,p2+1)
            }
        }
        return IntArray(2)
    }
}