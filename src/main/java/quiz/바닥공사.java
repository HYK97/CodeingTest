package quiz;

import java.util.Scanner;

public class 바닥공사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int DP[] = new int[N];

        DP[0] = 1;
        DP[1] = 3;
        for (int i = 2; i < N; i++) {
            DP[i] = (DP[i - 1] + (DP[i - 2] * 2)) % 796796;
        }
        System.out.println("DP[N - 1] = " + DP[N - 1]);


    }
}
