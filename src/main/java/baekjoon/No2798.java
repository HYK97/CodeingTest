package baekjoon;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class No2798 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        int target = Integer.parseInt(s[1]);
        int[] sorted = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
        int a;
        int b;
        int c;
        int temp = 0;
        for (int i = 0; i < sorted.length; i++) {
            a = sorted[i];
            if (a > target) {
                continue;
            }
            for (int j = i + 1; j < sorted.length; j++) {
                b = sorted[j];
                if (a + b > target) {
                    continue;
                }
                for (int k = j + 1; k < sorted.length; k++) {
                    c = sorted[k];
                    int result = a + b + c;
                    if (result == target) {
                        System.out.println(result);
                        return;
                    }
                    if (result < target && result > temp) {
                        temp = result;
                    }
                }
            }
        }
        System.out.println(temp);
    }
}
