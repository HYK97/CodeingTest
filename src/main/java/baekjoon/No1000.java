package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1000 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int c = Integer.parseInt(s[0]) + Integer.parseInt(s[1]);
        System.out.println(c);
        br.close();
    }
}
