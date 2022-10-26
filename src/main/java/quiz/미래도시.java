package quiz;


//플로이드 워셜 알고리즘

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * # 차이점
 * 다익스트라 알고리즘 vs 플로이드 워셜 알고리즘
 * -> 다익스트라 알고리즘은 특정 지점에서 다른 특정 지점까지의 최단경롤를 구해야하는 경우에사용
 * -> 플로이드 워셜 알고리즘은 모든 지점에서 다른 모든 지점까지의 최단경로를 구해야하는 경우에서용
 * # 특징
 * -> 다익스트라 알고리즘은 Heap을 사용
 * -> 플로이드 워셜 알고리즘은 배열과 다중 for(3중)을 사용해서 대부분 풀이한다.
 */
public class 미래도시 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] table = new int[N + 1][N + 1];


        int MAX_VALUE = 999999;

        for (int[] ints : table) {
            Arrays.fill(ints, MAX_VALUE);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    table[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int start = Integer.parseInt(s1[0]);
            int end2 = Integer.parseInt(s1[1]);
            table[start][end2] = 1;
            table[end2][start] = 1;
        }

        //
        for (int k = 1; k <= N; k++) {
            for (int a = 1; a <= N; a++) {
                for (int b = 1; b <= N; b++) {
                    /**
                     * 진행도
                     * k a b
                     * 1 1 1
                     * 1 1 2
                     * 1 1 3
                     * 1 2 1
                     * 1 2 2
                     * 1 2 3
                     * ...
                     *
                     *
                     * 1 2 3 해석
                     * 2에서 시작해서 1을 거쳐서 3에 도착하는 최소거리
                     *
                     * */


                    table[a][b] = Math.min(table[a][b], table[a][k] + table[k][b]);
                }
            }
        }


        String[] s2 = br.readLine().split(" ");
        int end = Integer.parseInt(s2[0]);
        int middle = Integer.parseInt(s2[1]);


        //1번에서 middle까지의 최소거리  +  middle 부터 end 까지의 최소 거리 즉 1
        int result = table[1][middle] + table[middle][end];
        if (result >= MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(result);
        }

    }

}
