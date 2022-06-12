package baekjoon;

import java.io.*;

public class No2884 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sTime = br.readLine();
        String[] timeData = sTime.split(" ");
        int H = Integer.parseInt(timeData[0]);
        int M = Integer.parseInt(timeData[1]);
        if (M - 45 < 0) {
            if (H - 1 < 0) {
                H = 24;
            }
            H--;
            M += 15;
        } else {
            M -= 45;
        }

        bw.write(H + " " + M);
        bw.flush();
    }
}
