package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No10986 {
    public static void main(String[] args) throws IOException {
        /*
         * N~M 까지의 합을 전부구한다
         * M의로 나누어가면서 떨어지는
         * */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] sum = new int[N + 1];
        int[] countArray = new int[M];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int mod = sum[i] % M;
            if (mod == 0) {
                count++;
            }
            countArray[mod]++;
        }

        for (int i = 0; i < M; i++) {
            // 조합공식 개수 * 개수 -1 /2
            int choice = countArray[i] * (countArray[i] - 1) / 2;
            count += choice;
        }
        System.out.println(count);

    }

}
