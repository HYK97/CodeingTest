package quiz;

import java.util.Scanner;

public class 시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        int count = 0;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if ((i + " " + j + " " + k).contains("3")) count++;
                }
            }
        }
        System.out.println("count = " + count);
    }
}
