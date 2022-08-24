package leetcode;

import java.util.Arrays;

public class No2160 {

    public static void main(String[] args) {
        int i = minimumSum(2436);
        System.out.println("i = " + i);
    }

    public static int minimumSum(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        int[] data = new int[4];
        for (int i = 0; i < chars.length; i++) {
            data[i] = chars[i] - '0';
        }
        int[] sorted = Arrays.stream(data).sorted().toArray();
        int[] first = new int[2];
        int[] second = new int[2];
        first[0] = sorted[0];
        second[0] = sorted[1];
        first[1] = sorted[2];
        second[1] = sorted[3];
        return Integer.parseInt(first[0] + "" + first[1]) + Integer.parseInt(second[0] + "" + second[1]);

    }
}
