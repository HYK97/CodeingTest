package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 개미전사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] K = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] sum = new int[N];
        sum[0] = K[0];
        sum[1] = Math.max(K[0], K[1]);
        for (int i = 2; i < N; i++) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + K[i]);
        }
        System.out.println("sum = " + sum[N - 1]);
    }
}