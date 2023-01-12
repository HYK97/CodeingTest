package baekjoon.dp;

import java.util.Scanner;

/**
 * packageName :  baekjoon.dp
 * fileName : No9095
 * author :  ddh96
 * date : 2023-01-13 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-13                ddh96             최초 생성
 */
public class No9095 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[11];
        result[0] = 1;
        result[1] = 2;
        result[2] = 4;
        for (int i = 3; i < 11; i++) {
            result[i] = result[i - 1] + result[i - 2] + result[i - 3];
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[sc.nextInt() - 1]);
        }
    }

}
