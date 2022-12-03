package math.recurrence;

/**
 * packageName :  math.recurrence
 * fileName : Practice1
 * author :  ddh96
 * date : 2022-12-02
 * description : 재귀함수
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class Practice1 {

    static int recursion1(int n) {
        if (n == 1) {
            return 1;
        }
        return 3 * recursion1(n - 1);
    }

    static int recursion2(int n) {
        if (n == 1) {
            return 1;
        }
        return recursion2(n - 1) + n;
    }

    static int recursion3(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return recursion3(n - 1) + recursion3(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("recursion1(4) = " + recursion1(4));
        System.out.println("recursion2(5) = " + recursion2(5));
        System.out.println("recursion3(6) = " + recursion3(6));
        System.out.println("fibonacci(6) = " + fibonacci(6));
    }

    static int fibonacci(int a) {
        int result = 0;
        int a1 = 1;
        int a2 = 1;
        if (a < 3) {
            return 1;
        } else {
            for (int i = 2; i < a; i++) {
                result = a1 + a2;
                a1 = a2;
                a2 = result;

            }
        }
        return result;
    }
}
