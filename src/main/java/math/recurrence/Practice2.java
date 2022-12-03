package math.recurrence;

/**
 * packageName :  math.recurrence
 * fileName : Practice2
 * author :  ddh96
 * date : 2022-12-03
 * description : 최대 공약수 재귀 방식 + 팩토리얼
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-03                ddh96             최초 생성
 */
public class Practice2 {
    static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // 두수의 최대공약수 구하는방법
    // a%b -> 0이 아니면 한번더 a%b나눈 나머지를 다시 재귀로 돌린다. 단 b 와 a b의 위치를 바꿔서
    static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return getGCD(b, a % b);
    }
}
