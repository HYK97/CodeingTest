class Solution {
  val hashMap = HashMap<Int, Int>()
    fun singleNumber(nums: IntArray): IntArray {
        val hashMap = HashMap<Int, Int>()
        for (num in nums) {
            hashMap[num] = hashMap[num]?.plus(1) ?: 1
        }
        val arrayList = ArrayList<Int>()
        for (mutableEntry in hashMap) {
            if (mutableEntry.value != 2) {
                arrayList.add(mutableEntry.key)
            }
        }
        return arrayList.toIntArray()
    }
}