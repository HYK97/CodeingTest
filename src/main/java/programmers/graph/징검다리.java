package programmers.graph;

import java.util.Arrays;

/**
 * packageName :  programmers.graph
 * fileName : 징검다리
 * author :  ddh96
 * date : 2023-03-30 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/43236
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-30                ddh96             최초 생성
 */
public class 징검다리 {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int left = 0;
        int right = distance;
        while (left <= right) {
            int prev = 0;
            int mid = (left + right) / 2;
            int count = 0;

            //[2, 11, 14, 17, 21]
            for (int rock : rocks) {
                if (rock - prev < mid) {
                    count++;
                } else {
                    //이전 돌의거리
                    prev = rock;
                }
            }
            if (distance - rocks[rocks.length - 1] < mid) {
                count++;
            }
            if (count <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }

}
