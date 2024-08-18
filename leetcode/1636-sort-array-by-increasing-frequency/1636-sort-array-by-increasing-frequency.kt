class Solution {
    val freq = nums.groupingBy { it }.eachCount()
    return nums.sortedWith(compareByDescending<Int> { freq[it] }.thenBy { -it }).toIntArray()
}