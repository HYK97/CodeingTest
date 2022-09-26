package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 왕실의나이트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] split = br.readLine().split("");
        int move = Vector.isMove(split[0].charAt(0), Integer.parseInt(split[1]));
        System.out.println("move = " + move);


    }


    static class Vector {
        static String[] move = new String[]{"2 -1", "2 1", "-2 -1", "-2 1", "1 2", "1 -2", "-1 2", "-1 -2"};

        public static int isMove(char x, int y) {
            int count = 0;

            for (String s : move) {
                String[] split = s.split(" ");
                int mx = Integer.parseInt(split[0]);
                int my = Integer.parseInt(split[1]);
                int i = x + mx;
                int j = y + my;
                if (i >= 'a' && i <= 'h' && j >= 1 && j <= 8) {
                    count++;
                }
            }
            return count;
        }
    }
}
