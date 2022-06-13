package codeup.basic;

import java.io.*;

public class No1015 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        float f = Float.parseFloat(s);
        bw.write(String.format("%.2f", f));
        bw.flush();
    }
}
