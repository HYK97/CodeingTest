package codeup.basic;

import java.io.*;

public class No1020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String[] split = s.split("-");
        String f = split[0];
        String b = split[1];
        bw.write(f + b);
        bw.flush();
    }
}
