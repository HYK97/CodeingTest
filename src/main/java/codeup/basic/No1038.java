package codeup.basic;

import java.io.*;

public class No1038 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] split = s.split(" ");
        long a = Long.parseLong(split[0]);
        long b = Long.parseLong(split[1]);
        bw.write(String.valueOf(a + b));
        bw.flush();
    }
}
