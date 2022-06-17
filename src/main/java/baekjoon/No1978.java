package baekjoon;

import java.io.*;

public class No1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N1 = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        //소수는 자기자신과 1로만 나누어지는 수
        //1부터 1000까지 나누자.개당 100개씩

        int count = 0;
        for (int i = 0; i < N1; i++) {
            int data = Integer.parseInt(split[i]);
            if (data == 1) {
                count++;
            } else {
                for (int j = 1; j < 1000; j++) {
                    if (data == 2) {
                        break;
                    } else if (j > 1 && j < data && data % j == 0) {
                        count++;
                        break;
                    }
                }

            }
        }
        bw.write(String.valueOf(N1 - count));
        bw.flush();

    }
}
