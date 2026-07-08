class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        val result = mutableListOf<Int>()
        val wordLeng = words[0].length
        val targetMap = mutableMapOf<String, Int>()
        for (word in words) {
            targetMap[word] = targetMap.getOrDefault(word, 0) + 1
        }
        for (i in 0 until wordLeng) {
            var left = i
            var right = i
            val currentMap = mutableMapOf<String, Int>()
            var count = 0 // 현재 윈도우에 담긴 유효 단어 개수

            while (right + wordLeng <= s.length) {
                val word = s.substring(right, right + wordLeng)
                right += wordLeng

                if (targetMap.containsKey(word)) {
                    currentMap[word] = currentMap.getOrDefault(word, 0) + 1
                    count++

                    // 만약 단어 개수가 목표보다 많아지면, 왼쪽을 당겨서 소화시킴!
                    while (currentMap[word]!! > targetMap[word]!!) {
                        val leftWord = s.substring(left, left + wordLeng)
                        currentMap[leftWord] = currentMap[leftWord]!! - 1
                        count--
                        left += wordLeng
                    }

                    // 모든 단어를 다 찾았다면
                    if (count == words.size) {
                        result.add(left)
                    }
                } else {
                    // 아예 모르는 단어가 나오면? 싹 비우고 점프!
                    currentMap.clear()
                    count = 0
                    left = right
                }
            }
        }
        return result
    }
}
