package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 주식가격 {

    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 2, 3});
    }

    public static int[] solution(int[] prices) {
        Queue que = new LinkedList();
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int first = 0;
            int count = 0;
            for (int j = i; j < prices.length; j++) {
                if (que.isEmpty()) {
                    first = prices[j];
                    que.add(prices[j]);
                } else {
                    if (first > prices[j]) {
                        count++;
                        break;
                    } else {
                        que.add(prices[j]);
                        count++;
                    }
                }
            }
            answer[i] = count;
            que.clear();
        }
        return answer;
    }
}
