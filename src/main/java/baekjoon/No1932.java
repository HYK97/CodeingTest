package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No1932 {
    static int[][] arr;
    static Integer[][] table;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        arr = new int[N][N];
        table = new Integer[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < N; i++) {
            table[N - 1][i] = arr[N - 1][i];
        }
        System.out.println(recursion(0, 0));

    }

    static int recursion(int depth, int index) {
        if (depth == N - 1) return table[depth][index];
        if (table[depth][index] == null) {
            table[depth][index] = Math.max(recursion(depth + 1, index), recursion(depth + 1, index + 1)) + arr[depth][index];
        }
        return table[depth][index];

    }
}