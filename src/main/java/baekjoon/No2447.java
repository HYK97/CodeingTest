package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class No2447 {

    public static char[][] arr;

    public static void solve(int n, int x, int y) {
        if (n == 1) {
            arr[x][y] = '*';
            return;
        }
        int value = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1)
                    continue;
                else
                    solve(value, x + (value * i), y + (value * j));
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(arr[i], ' ');
        }
        solve(n, 0, 0);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
