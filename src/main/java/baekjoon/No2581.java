package baekjoon;

import java.io.*;

public class No2581 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        boolean first = true;
        boolean sosu = false;
        int min = 0;
        for (int j = M; j <= N; j++) {
            if (j == 2) {
                sosu = true;
            } else {
                for (int i = 2; i < j; i++) {
                    if (j % i == 0) {
                        sosu = false;
                        break;
                    } else {
                        sosu = true;
                    }
                }
            }
            if (sosu) {
                sum += j;
                if (first) {
                    min = j;
                    first = false;
                }
                sosu = false;
            }
        }
        if (sum > 0) {
            bw.write(String.valueOf(sum + "\n"));
            bw.write(String.valueOf(min));
        } else {
            bw.write(String.valueOf(-1));
        }

        bw.flush();

    }
}
