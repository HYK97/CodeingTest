class Solution {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size

        // 1) gaps[0..n]: 회의 전, 사이, 후에 생기는 자유 시간 구간
        val gaps = LongArray(n + 1)
        gaps[0] = startTime[0].toLong()                 // 0부터 첫 회의 시작 전
        for (i in 1 until n) {
            gaps[i] = (startTime[i] - endTime[i - 1]).toLong()  
            // i번째 회의 시작과 (i-1)번째 회의 종료 사이
        }
        gaps[n] = (eventTime - endTime[n - 1]).toLong() // 마지막 회의 종료 후 ~ 이벤트 종료

        // 2) 원래 자유 구간 중 값이 큰 4개만 (값, 인덱스) 형태로 저장
        val top4 = mutableListOf<Pair<Long, Int>>()
        for (i in 0..n) {
            top4 += (gaps[i] to i)
            top4.sortByDescending { it.first }
            if (top4.size > 4) top4.removeLast()      // 4개 초과 시 가장 작은 것 제거
        }

        var answer = 0L

        // 3) k번째 회의를 하나씩 제거하고 최적 재배치 계산
        for (k in 0 until n) {
            val dur = (endTime[k] - startTime[k]).toLong()

            // 3-1) 제거 시, gaps[k] + dur + gaps[k+1]이 병합되어 하나의 구간으로
            val merged = gaps[k] + dur + gaps[k + 1]

            // 3-2) 후보 구간 리스트 구성
            val candidates = mutableListOf<Long>()
            for ((v, idx) in top4) {
                // top4 중 k 혹은 k+1 인덱스 제외
                if (idx != k && idx != k + 1) {
                    candidates += v
                }
            }
            candidates += merged   // 병합 구간 추가
            candidates.sortDescending() // 큰 순서로 정렬

            // 3-3) M1, M2 추출
            val M1 = candidates[0]
            val M2 = if (candidates.size > 1) candidates[1] else 0L

            // 3-4) 재삽입 후 남는 최대 free time 계산
            //   M2 >= dur 이면 다른 큰 구간에 넣어서 M1 보존
            //   아니면 M1에서 dur을 빼거나 M2 중 큰 값
            val best = if (M2 >= dur) {
                M1
            } else {
                maxOf(M2, M1 - dur)
            }
            answer = maxOf(answer, best)
        }

        return answer.toInt()
    }
}