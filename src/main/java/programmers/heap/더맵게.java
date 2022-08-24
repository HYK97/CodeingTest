package programmers.heap;

import java.util.PriorityQueue;

public class 더맵게 {
    public static void main(String[] args) {

        System.out.println(solution(new int[]{1, 2, 12, 9, 10, 3}, 10));
    }

    //1, 2, 3, 9, 10, 12
    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> data = new PriorityQueue<>();
        for (int i : scoville) {
            data.add(i);
        }

        int answer = 0;
        while (true) {
            Integer peek = data.peek();
            if (data.size() == 1 && peek < K) {
                return -1;
            }
            if (peek >= K) {
                return answer;
            }

            Integer first = data.poll();
            Integer second = data.poll();
            data.add(first + second * 2);

            answer++;
        }
    }
}
