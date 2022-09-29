package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음료수얼려먹기 {
    static int[][] data;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(split[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) {
                    result++;
                }
            }
        }
        System.out.println("result = " + result);
    }

    private static boolean dfs(int i, int j) {
        if (i <= -1 || i >= N || j <= -1 || j >= M) {
            return false;
        }
        if (data[i][j] == 0) {
            data[i][j] = 1;
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
            return true;
        } else {
            return false;
        }
    }


}
