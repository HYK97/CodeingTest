package baekjoon;

import java.io.*;

public class No1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        int max = 0;
        double result = 0;
        for (String s : split) {
            result += Integer.parseInt(s);
            if (max < Integer.parseInt(s)) {
                max = Integer.parseInt(s);
            }
        }
        result = result * 100 / max / count;
        bw.write(String.valueOf(result));
        bw.flush();

    }
}
