package baekjoon;

import java.io.*;

public class No1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int M = Integer.parseInt(split[0]);// 범위 M ~ N 까지의 소수 구하기
        int N = Integer.parseInt(split[1]);
        int[] data = new int[10000001]; // M~N 에 해당하는 data[index]에 숫자 1로변경
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
        for (int i = M; i <= N; i++) {
            if (data[i] == 1) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
