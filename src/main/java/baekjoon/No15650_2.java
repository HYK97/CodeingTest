package baekjoon;


import java.io.*;

public class No15650_2 {
    static int N;
    static int M;
    static int[] data;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        data = new int[M];
        tracking(0, 1);
        bw.flush();
    }

    public static void tracking(int depth, int start) throws IOException {
        if (depth == M) {
            for (Integer integer : data) {
                bw.write(integer + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = start; i <= N; i++) {
            data[depth] = i;
            tracking(depth + 1, i + 1);
        }
    }
}
