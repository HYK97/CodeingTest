package baekjoon;

public class No15596 {
    public static void main(String[] args) {
        int[] co = {1, 1, 23, 45, 2, 4, 2, 43, 23, 2, 1, 231, 23, 1, 23, 1, 23, 12, 31, 24, 12, 4};
        long sum = sum(co);
        System.out.println("sum = " + sum);
    }

    public static long sum(int[] a) {
        long result = 0;
        for (int i : a) {
            result += i;
        }
        return result;
    }
}
