package codeup.basic;

import java.io.*;

public class No1079 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        for (String s : split) {
            System.out.println(s);
            if (s.equals("q")) {
                break;
            }
        }
    }
}
