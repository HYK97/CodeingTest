package codeup.basic;

import java.io.*;

public class No1165 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int time = Integer.parseInt(split[0]);
        int oneBanNowScore = Integer.parseInt(split[1]);
        int twoBanNowScore = 2;
        while (time < 90) {
            time += 5;
            oneBanNowScore++;
        }
        bw.write(String.valueOf(oneBanNowScore));
        bw.flush();
    }
}
