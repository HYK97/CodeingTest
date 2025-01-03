class Solution {
    fun maxVowels(s: String, k: Int): Int {
        // 모음문자의 최대 개수
        // k는 몇개씩 자를꺼냐에 대한거
        // 리턴은 k개씩 잘랐을때 오는 최대 모음 문자의 개수
        var max = 0
        var start = 0
        var end = k
        val array = s.toCharArray()
        var count = 0
        for (i in start..<end) {
            if (isVowels(array[i])) {
                count++
            }
        }
        max = count
        start++
        end++

        while (end <= s.length) {
            if (isVowels(array[end - 1])) {
                count++
            }
            if (isVowels(array[start])) {
                count--
            }
            max = max(count, max)
            start++
            end++
        }
        return max
    }

    private fun isVowels(value: Char) = value == 'a' || value == 'e' || value == 'i' || value == 'o' || value == 'u'
}