package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class No4673 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < 10000; i++) {
            if (check(i)) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();


    }

    public static boolean check(int data) {
        char[] chars;
        int result;
        for (int i = 1; i < data; i++) {
            result = i;
            chars = String.valueOf(i).toCharArray();
            for (int j = 0; j < chars.length; j++) {
                result += chars[j] - '0';
            }
            if (result == data) {
                return false;
            }
            chars = null;
        }
        return true;
    }
}
