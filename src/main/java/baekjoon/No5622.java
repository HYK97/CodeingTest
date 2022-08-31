package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No5622 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split("");
        String[] data = new String[]{"", "", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int result = input.length;
        for (int i = 0; i < input.length; i++) {
            for (int j = 2; j < data.length; j++) {
                String s = input[i];
                if (data[j].contains(s)) {
                    result += j;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
