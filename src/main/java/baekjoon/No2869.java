package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data = br.readLine().split(" ");
        int A = Integer.parseInt(data[0]);
        int B = Integer.parseInt(data[1]);
        int C = Integer.parseInt(data[2]);
        int dvi = (C - A) / (A - B);
        if ((dvi * (A - B)) + A >= C) {
            System.out.println(dvi + 1);
        } else {
            System.out.println(dvi + 2);
        }
        br.close();
    }
}
