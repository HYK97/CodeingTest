package programmers.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class 프린터 {
    public static void main(String[] args) {
        int solution = solution(new int[]{2, 1, 3, 2}, 2);
        System.out.println("solution = " + solution);
    }

    public static int solution(int[] priorities, int location) {

        Deque<Integer> queue = new LinkedList<>();
        int answer = 1;
        for (int i = 0; i < priorities.length; i++) {
            queue.addLast(i);
        }
        while (!queue.isEmpty()) {
            Integer peek = queue.peekFirst();
            boolean lastGo = false;
            for (int priority : priorities) {
                if (priorities[peek] < priority) {
                    lastGo = true;
                    break;
                }
            }
            if (lastGo) {
                queue.removeFirst();
                queue.addLast(peek);
            } else {
                if (location == peek) {
                    break;
                } else {
                    queue.removeFirst();
                    priorities[peek] = 0;
                    answer++;
                }
            }
        }
        return answer;
    }

}
