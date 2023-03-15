package priv;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class 문제3 {
    public static void main(String[] args) {
        System.out.println("solution = " + Arrays.toString(solution(3, new int[] {4, 2, 2, 5, 3})));
    }

    public static int[] solution(int N, int[] coffee_times) {
        int[] answer = new int[coffee_times.length];
        int[] order = new int[N];
        int[] making = new int[N];

        int minTimes = Arrays.stream(coffee_times).min().getAsInt();

        int coffeeIdx = 0;
        for (int i = 0; i < making.length; i++) {
            making[i] = coffee_times[i] - minTimes + 1;
            order[i] = coffeeIdx;
            coffeeIdx++;
        }

        int complete = 0;

        while (complete != coffee_times.length) {
            List<Integer> sameComplete = new ArrayList<>();
            int i = 0;
            while (i < making.length) {
                making[i]--;
                if (making[i] == 0) {
                    sameComplete.add(order[i] + 1);
                    if (coffeeIdx < coffee_times.length) {
                        making[i] = coffee_times[coffeeIdx] - minTimes + 1;
                        order[i] = coffeeIdx;
                        coffeeIdx++;
                    }
                }
                i++;
            }
            complete = orderAtTheSameTime(answer, complete, sameComplete);
        }
        return answer;
    }

    private static int orderAtTheSameTime(int[] answer, int complete, List<Integer> sameComplete) {
        sameComplete.sort(Comparator.naturalOrder());
        for (Integer integer : sameComplete) {
            answer[complete] = integer;
            complete++;
        }
        return complete;
    }
}
