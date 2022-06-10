package baekjoon;

import java.io.*;

public class No10989 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] cnt = new int[10001];
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            cnt[Integer.parseInt(br.readLine())]++;
        }
        for (int i = 1; i < 10001; i++) {
            while (cnt[i] != 0) {
                bw.write(i + "\n");
                cnt[i]--;
            }
        }
        bw.flush();
    }
}
