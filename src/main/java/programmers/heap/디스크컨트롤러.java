package programmers.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class 디스크컨트롤러 {
    public static void main(String[] args) {

        PriorityQueue<int[]> data = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int[][] jobs = new int[][]{{0, 3}, {1, 9}, {2, 6}};
        Arrays.sort(jobs, (Comparator.comparingInt(o -> o[0])));
        int answer = 0;
        int endTime = 0;
        int count = 0;
        int i = 0;
        while (count < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= endTime) {
                data.add(jobs[i++]);
            }
            if (data.isEmpty()) {
                endTime = jobs[i][0];
            } else {
                int[] poll = data.poll();
                answer += poll[1] + endTime - poll[0];
                endTime += poll[1];
                count++;
            }
        }
        System.out.println(answer / jobs.length);
    }
}
