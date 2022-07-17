package programmers.stack_queue;

import java.util.ArrayList;
import java.util.List;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        solution(new int[]{1, 1, 3, 3, 0, 1, 1});
    }

    public static int[] solution(int[] arr) {

        int buf = 0;
        List<Integer> result = new ArrayList<>();
        for (int i : arr) {
            if (result.size() == 0) {
                result.add(i);
                buf = i;
                continue;
            }
            if (buf != i) {
                result.add(i);
                buf = i;
            }
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}

