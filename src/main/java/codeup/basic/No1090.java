package codeup.basic;

import java.io.*;

public class No1090 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        long a = Integer.parseInt(split[0]);
        int r = Integer.parseInt(split[1]);
        int n = Integer.parseInt(split[2]);
        for (int i = 1; i < n; i++) {
            a = a * r;
        }
        bw.write(String.valueOf(a));
        bw.flush();
    }
}
