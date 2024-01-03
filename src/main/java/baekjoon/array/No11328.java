package baekjoon.array;

import java.io.*;
import java.util.Arrays;


public class No11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            char[] alp1=new char[26];
            char[] alp2=new char[26];
            String []s = br.readLine().split(" ");
            char[] original = s[0].toCharArray();
            char[] target = s[1].toCharArray();

            for (char c : original) {
                alp1[c-97]++;
            }

            for (char c : target) {
                alp2[c-97]++;
            }

            boolean flag =true;
            for (int j = 0; j < 26; j++) {
                if (alp1[j] != alp2[j]) {
                    bw.write("Impossible");
                    flag=false;
                    break;
                }
            }
            if (flag) {
                bw.write("Possible");
            }
            bw.newLine();
        }
        bw.close();
    }
}