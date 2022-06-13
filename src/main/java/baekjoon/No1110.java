package baekjoon;

import java.io.*;

public class No1110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        int firstData = Integer.parseInt(s);
        int next = firstData;
        int count = 0;
        do {
            int fir = (next % 100) / 10; //첫번째 자리
            int sec = next % 10;//두번째 자리
            int sum = fir + sec;
            next = Integer.parseInt(String.format("%d%d", next % 10, sum % 10));
            count++;
        }
        while (firstData != next);
        bw.write(String.valueOf(count));
        bw.flush();
    }
}
