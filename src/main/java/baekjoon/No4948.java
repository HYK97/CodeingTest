package baekjoon;

import java.io.*;

public class No4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] data = new int[123457 * 2];

        while (true) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                break;
            }
            int M = input + 1;
            int N = input * 2;
            int probablePrime = isProbablePrime(M, N, data);
            bw.write(probablePrime + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }

    public static int isProbablePrime(int M, int N, int[] data) {
        for (int i = 2; i <= N; i++) {
            data[i] = 1;
        }
        for (int i = 2; i <= N; i++) {
            if (data[i] == 0) {
                continue;
            }
            for (int j = i + i; j <= N; j += i) {
                data[j] = 0;
            }
        }
        int count = 0;
        for (int i = M; i <= N; i++) {
            if (data[i] == 1) {
                count++;
            }
        }
        return count;
    }
}
