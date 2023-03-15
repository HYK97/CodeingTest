package priv;

import java.util.List;

public class 문제2 {
    static int minLines;
    static boolean[] visited;
    static int MAX = 11;

    public static void dfs(int start, int[] lines, int[] dots, int count) {
        if (count >= minLines) {
            return;
        }
        if (start > dots[dots.length - 1]) {
            minLines = count;
            return;
        }

        for (int dot : dots) {
            if (start <= dot) {
                start = dot;
                break;
            }
        }

        for (int i = 0; i < lines.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(start + lines[i] + 1, lines, dots, count + 1);
                visited[i] = false;
            }
        }

    }

    public static int solution(int[] dots, int[] lines) {
        minLines = MAX;
        visited = new boolean[lines.length];
        dfs(dots[0], lines, dots, 0);
        if (minLines == MAX) {
            return -1;
        } else {
            return minLines;
        }

    }

    public static void main(String[] args) {

        List<Integer> test = List.of(
            solution(new int[] {1, 3, 4, 6, 7, 10}, new int[] {2, 2, 2, 2}),
            solution(new int[] {1, 5, 8}, new int[] {1, 3, 4, 6}),
            solution(new int[] {5, 8, 20, 100}, new int[] {2, 3}),
            solution(new int[] {3, 100, 102}, new int[] {1, 1, 1}),
            solution(new int[] {1}, new int[] {1}),
            solution(new int[] {1, 50, 51, 52, 100}, new int[] {1, 1, 5}),
            solution(new int[] {1, 3, 4, 7, 8, 10}, new int[] {2, 2, 2, 2})
        );
        for (Integer integer : test) {
            System.out.println("test = " + integer);
        }

    }
}