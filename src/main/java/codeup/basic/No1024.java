package codeup.basic;

import java.io.*;

public class No1024 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            bw.write("\'" + aChar + "\'" + "\n");
        }
        bw.flush();
    }
}
