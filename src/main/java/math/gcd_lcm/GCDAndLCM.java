package math.gcd_lcm;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  math
 * fileName : GCDAndLCM
 * author :  ddh96
 * date : 2022-12-02
 * description : 최대 공약수 최소공배수
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class GCDAndLCM {

    public static void main(String[] args) {
        int number1 = 10;
        int number2 = 6;

        GCDAndLCM test = new GCDAndLCM();

        int gcd = test.getGCD(number1, number2);
        int lcm = test.getLCM(number1, number2);
        System.out.println("최대공배수 = " + gcd);
        System.out.println("최소공약수 = " + lcm);


    }

    //약수
    public List<Integer> getDivisor(int num) {
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i < num / 2; i++) { // 전체를 순회하지않는 이유는 반보다크면 항상 나누어 떨어지지않고 나머지가 발생하기떄문
            if (num % i == 0) {
                result.add(i);
            }
        }
        result.add(num);
        return result;
    }

    public int getGCD(int numA, int numB) {
        List<Integer> divisorA = getDivisor(numA);
        List<Integer> divisorB = getDivisor(numB);

        int GCD = -1;
        for (Integer a : divisorA) {
            for (Integer b : divisorB) {
                if (a == b) {
                    GCD = Math.max(a, GCD);
                }
            }
        }
        return GCD;

    }

    public int getLCM(int numA, int numB) {
        int lcm = -1;
        int gcd = getGCD(numA, numB);
        if (gcd == -1) {
            throw new IllegalArgumentException("최소공배수 없음");
        }

        lcm = numA * numB / gcd;
        return lcm;
    }
}
