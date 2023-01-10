package programmers.ex_search;

import java.util.Arrays;

public class 양궁대회 {

    static int[] infos;
    static int maxDiff = Integer.MIN_VALUE;
    static int[] answers = new int[11];

    static boolean first = true;

    public static void main(String[] args) {
        solution(9, new int[] {1, 1, 2, 0, 1, 2, 2, 0, 0, 0, 0});
    }

    public static int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        infos = info;
        //n발씩쏘고
        //동점이면 어피치가 이김 a==b 0인경우에는 아무도 점수를 얻지않음
        // info는 어피치가 맞힌 과녁 점수의 개수를 10~ 0점까지 순서대로 잠으
        // 정답은 라이언이 가장큰점수로 우승해야함 이떄 n발의 화살을 어떤 과녁에 맞춰야하는지 10점부터 0점까지 ->
        // 라이언이 우승할 수 없는 경우(무조건 지거나 비기는 경우)는 [-1]

        //5개로 11자리에 주는 중복조합
        //1 1 1 1 1

        dfs(0, answer, n, 11);
        System.out.println("Arrays.toString(answers) = " + Arrays.toString(answers));
        System.out.println(maxDiff);
        return maxDiff == Integer.MIN_VALUE ? new int[] {-1} : answers;
    }

    public static void dfs(int depth, int[] answer, int n, int round) {
        if (n == 0) {
            int ry = 0;
            int ap = 0;

            for (int i = 0; i < 11; i++) {
                int point = 10 - i;
                if (answer[i] < infos[i]) {
                    ap += point;
                } else if (answer[i] > infos[i]) {
                    ry += point;
                } else if (infos[i] != 0 && answer[i] == infos[i]) {
                    ap += point;
                }
            }

            if (ry > ap) {
                int diff = ry - ap;

                if (first) {
                    maxDiff = diff;
                    answers = answer.clone();
                    first = false;
                    return;
                }
                if (maxDiff < diff) {
                    maxDiff = diff;
                    answers = answer.clone();
                }
                if (maxDiff == diff) {
                    int[] arr = checkArr(answers, answer);
                    answers = arr.clone();

                }
            }

            return;
        }
        if (depth == 11) {

            return;
        }

        answer[depth]++;
        dfs(depth, answer, n - 1, round - 1);
        answer[depth]--;
        dfs(depth + 1, answer, n, round);

    }

    private static int[] checkArr(int[] a, int[] b) {
        for (int i = a.length - 1; i >= 0; i--) {
            if (a[i] == b[i])
                continue;
            if (a[i] < b[i])
                return b;
            break;
        }
        return a;
    }
}