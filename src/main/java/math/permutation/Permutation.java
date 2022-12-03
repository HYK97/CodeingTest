package math.permutation;

import java.util.stream.IntStream;

/**
 * packageName :  math
 * fileName : Permutation
 * author :  ddh96
 * date : 2022-12-02
 * description : 순열
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class Permutation {

    public static void main(String[] args) {
        Permutation p = new Permutation();
        System.out.println("팩토리얼 5 -> " + p.factorial(5));
        System.out.println("5명을 3줄로세우는 경우의수 " + p.permutation(5, 3));
        System.out.println("다른 4개의수 중에 2개를 뽑는 경우의수 " + p.doublePermutation(4, 2));
        System.out.println("원 모양의 테이블에 3명을 앉히는 경우의 수 " + p.circlePermutation(3));
    }

    public int factorial(int a) {
        return IntStream.range(1, a + 1).reduce(1, (x, y) -> x * y);
    }

    public int permutation(int n, int r) {
//        int a = n - r;
//        int b = factorial(n);
//        return b / a;
        //또는
        int result = 1;
        System.out.println("n" + " r " + " i " + " n-r+1");
        for (int i = n; i >= n - r + 1; i--) {
            System.out.println(n + " " + r + " " + " " + i + " " + "   " + (n - r + 1) + " ");
            result *= i;
        }
        /**
         *       n      r          n-r+1           i
         *       5      3            3     <=      5
         *       5      3            3     <=      4
         *       5      3            3     <=      3      결과 5x4x3 =60
         * ==================================================
         *       5      3            3     <=      2
         * */
        return result;
    }

    public int doublePermutation(int n, int r) {
        int result = 1;
        for (int i = 0; i < r; i++) {
            result *= n;
        }
        return result;
    }

    public int circlePermutation(int n) {
        int result = 1;
        for (int i = 1; i < n; i++) {
            result *= i;
        }
        return result;

    }


}
