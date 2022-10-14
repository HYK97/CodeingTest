package quiz;

import java.util.Scanner;

public class 일로만들기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int[] table = new int[30001];

        for (int i = 2; i <= t; i++) {
            table[i] = table[i - 1] + 1;
            if (i % 5 == 0) {
                table[i] = Math.min(table[i], table[i / 5] + 1);
            }
            if (i % 3 == 0) {
                table[i] = Math.min(table[i], table[i / 3] + 1);
            }
            if (i % 2 == 0) {
                table[i] = Math.min(table[i], table[i / 2] + 1);
            }
        }

        System.out.println("table = " + table[t]);

    }
}
