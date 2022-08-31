package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No1065 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int index = Integer.parseInt(input);
        int count = 0;
        for (int i = 1; i <= index; i++) {
            if (check(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check(int data) {
        char[] chars = String.valueOf(data).toCharArray();
        if (data < 100) {
            return true;
        }
        int measure = (chars[0] - '0') - (chars[1] - '0');
        for (int i = 1; i < chars.length; i++) {
            if (i + 1 < chars.length && measure != (chars[i] - '0') - (chars[i + 1] - '0')) {
                return false;
            }
        }
        return true;
    }
}
