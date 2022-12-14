package naver_intern;

import java.util.Arrays;

/**
 * packageName :  naver_intern
 * fileName : no7
 * author :  ddh96
 * date : 2022-12-14 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/43238?itm_content=course14743
 *
 * 아이디어 최소 시간과 최대시간을 기준으로 left
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no7 {
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long min = 0;                        // 최소 시간수
        long max = (long)times[times.length - 1] * n; //검사에걸리는 최대시간
        //
        while (min <= max) {
            long middle = (min + max) / 2;
            long success = 0;
            for (int time : times) {
                success += middle / time;
            }

            if (success < n) {
                min = middle + 1;
            } else {
                max = middle - 1;
                answer = middle;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        long solution = solution(14, new int[] {7, 10, 11, 20});
        System.out.println("solution = " + solution);

    }
}
