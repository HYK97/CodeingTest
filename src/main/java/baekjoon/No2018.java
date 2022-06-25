package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2018 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int count = 0;
        for (int i = 1; i <= N; i++) {
            int k = 0;
            for (int j = i; j <= N; j++) {
                k += j;
                if (k == N) {
                    count++;
                } else if (k > N) {
                    break;
                }
            }
        }
        System.out.println("count = " + count);
    }
}
