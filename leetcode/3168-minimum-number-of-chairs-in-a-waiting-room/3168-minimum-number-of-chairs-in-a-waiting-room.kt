class Solution {
    fun minimumChairs(s: String): Int {
        val linkedList = LinkedList<Byte>()
        var maxSize = -1
        for (c in s) {
            if (c == 'E') {
                linkedList.add(1)
            } else {
                linkedList.poll()
            }
            maxSize = maxSize.coerceAtLeast(linkedList.size)
        }
        return maxSize
    }
}