package programmers.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * packageName :  programmers.heap
 * fileName : 이중우선순위큐
 * author :  ddh96
 * date : 2022-12-21 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42628
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-21                ddh96             최초 생성
 */
public class 이중우선순위큐 {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int[] answer = {0, 0};
        for (int i = 0; i < operations.length; i++) {
            String[] split = operations[i].split(" ");

            if (split[0].equals("I")) {
                minHeap.add(Integer.valueOf(split[1]));
                maxHeap.add(Integer.valueOf(split[1]));
            }
            if (operations[i].equals("D 1")) {
                Integer poll = maxHeap.poll();
                minHeap.remove(poll);
            }
            if (operations[i].equals("D -1")) {
                Integer poll = minHeap.poll();
                maxHeap.remove(poll);
            }
        }
        if (minHeap.size() > 0) {
            return new int[] {maxHeap.poll(), minHeap.poll()};
        }

        return answer;

    }

}


