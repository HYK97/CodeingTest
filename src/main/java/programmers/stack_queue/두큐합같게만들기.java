package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName :  programmers.stack_queue
 * fileName : 두큐합같게만들기
 * author :  ddh96
 * date : 2022-12-27 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/118667
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-27                ddh96             최초 생성
 */
public class 두큐합같게만들기 {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();
        for (int a : queue1) {
            que1.offer((long)a);
        }
        for (int b : queue2) {
            que2.offer((long)b);
        }
        long que1Sum = que1.stream().reduce(0L, Long::sum);
        long que2Sum = que2.stream().reduce(0L, Long::sum);
        int maxCount = que1.size() * 3;
        int count = 0;
        while (que1Sum != que2Sum) {
            if (maxCount < 0) {
                break;
            }
            if (que1Sum > que2Sum) {
                Long poll = que1.poll();
                que2.offer(poll);
                que1Sum -= poll;
                que2Sum += poll;
                count++;
                maxCount--;
                continue;
            }
            if (que1Sum < que2Sum) {
                Long poll = que2.poll();
                que1.offer(poll);
                que1Sum += poll;
                que2Sum -= poll;
                count++;
                maxCount--;
            }

        }
        if (maxCount < 0) {
            return answer;
        } else {
            return count;
        }

    }
}
