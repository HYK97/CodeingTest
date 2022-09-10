package baekjoon;

import java.io.*;

public class No1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int data = Integer.parseInt(br.readLine());
        int i = 0;
        int count = 0;
        while (true) {
            if (String.valueOf(i).contains("666")) {
                if (count == data - 1) {
                    System.out.println(i);
                    break;
                }
                count++;
            }
            i++;
        }

        bw.flush();
    }
}
