package leetcode

import java.util.Comparator

class Sol37 {
    fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        val hashMap = HashMap<Int, String>()
        for (i in names.indices) {
            hashMap[ heights[i]] = names[i]
        }
        val mutableMap = hashMap.toList().sortedByDescending { it.first }.toMap() as MutableMap
        return mutableMap.values.toTypedArray()
    }
}