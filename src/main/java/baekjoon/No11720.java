package baekjoon;

import java.io.*;

public class No11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();
        int result = 0;
        for (char aChar : chars) {
            result += aChar - '0';
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
