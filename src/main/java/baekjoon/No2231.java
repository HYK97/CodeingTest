package baekjoon;

import java.io.IOException;
import java.util.Scanner;

public class No2231 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int intData = Integer.parseInt(sc.nextLine());
        for (int i = 1; i < intData - 1; i++) {
            int result = i;
            String[] indexData = String.valueOf(i).split("");
            for (int j = 0; j < indexData.length; j++) {
                result += Integer.parseInt(indexData[j]);
            }
            if (result == intData) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");
    }
}
