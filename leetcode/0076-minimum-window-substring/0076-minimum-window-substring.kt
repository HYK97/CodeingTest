class Solution {
    fun minWindow(s: String, t: String): String {
        // 1. targetMap 만들기
        val targetMap = mutableMapOf<Char, Int>()
        for (char in t) {
            targetMap[char] = targetMap.getOrDefault(char, 0) + 1
        }

        // 2. 변수 초기화
        val currentMap = mutableMapOf<Char, Int>()
        var check = 0
        // 문자의 종류 수
        val required = targetMap.size 
        
        var left = 0
        var right = 0
        
        // 정답 기록용 변수
        var minLen = Int.MAX_VALUE
        var minStart = 0
        var found = false

        while (right < s.length) {
            val charRight = s[right]
            
            // 3. 확장
            currentMap[charRight] = currentMap.getOrDefault(charRight, 0) + 1
            
            // target에 있는 문자이고, 개수가 목표치와 딱! 같아졌을 때만 check 증가
            if (targetMap.contains(charRight) && currentMap[charRight] == targetMap[charRight]) {
                check++
            }

            // 4. 축소 - 조건이 만족되는 동안 계속
            while (check == required && left <= right) {
                // (1) 현재 상태가 정답 후보이므로 길이 갱신
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1
                    minStart = left
                    found = true
                }

                // (2) 왼쪽 문자 제거
                val charLeft = s[left]
                currentMap[charLeft] = currentMap[charLeft]!! - 1
                
                // (3) 상태 점검: 문자를 뺐더니 조건이 깨졌는가?
                if (targetMap.contains(charLeft) && currentMap[charLeft]!! < targetMap[charLeft]!!) {
                    check-- // 유효 상태 깨짐 -> while문 종료됨
                }
                
                left++ // 윈도우 축소
            }
            right++ // 윈도우 확장
        }

        return if (found) s.substring(minStart, minStart + minLen) else ""
    }
}