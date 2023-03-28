package programmers.greedy;

import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * packageName :  programmers.greedy
 * fileName : 구명보트
 * author :  ddh96
 * date : 2023-03-28 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/42885
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class 구명보트 {
    public static void main(String[] args) {
        int solution = solution(new int[] {10, 20, 30, 10}, 100);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] people, int limit) {

        int answer = 0;

        Arrays.sort(people);

        ArrayDeque<Integer> queue = new ArrayDeque<>(50001);

        for (int person : people) {
            queue.add(person);
        }

        while (!queue.isEmpty()) {
            int weight = queue.pollLast();
            //양쪽 크기 합쳐서 확인하기
            if (!queue.isEmpty() && weight + queue.peekFirst() <= limit) {
                queue.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}
