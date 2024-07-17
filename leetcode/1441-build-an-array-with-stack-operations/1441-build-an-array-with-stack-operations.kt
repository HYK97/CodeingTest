class Solution {
    fun buildArray(target: IntArray, n: Int): List<String> {
        var index = 0
        val result = mutableListOf<String>()
        val data = IntStream.range(1, n + 1).toArray()
        println("data = ${data.contentToString()}")
        var dataIndex = 0
        while (true) {
            var i = data[dataIndex]
            if (target[index] == i) {
                result.add("Push")
                index++
            } else {
                result.add("Push")
                result.add("Pop")
            }
            dataIndex++
            if (dataIndex == n - 1 || index == target.size) {
                break
            }
            
        }
        if (data[dataIndex] == target.last()) {
            result.add("Push")
        }
        return result
    }
    
}