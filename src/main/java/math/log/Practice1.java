package math.log;

/**
 * packageName :  math.log
 * fileName : Practice1
 * author :  ddh96
 * date : 2022-12-03
 * description :제곱 제곱근 지수
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-03                ddh96             최초 생성
 */
public class Practice1 {

    static double pow(double a, double b) {

        boolean isMinus = false;
        if (b == 0) {
            return 1;
        } else if (b < 0) {
            b *= -1;
            isMinus = true;
        }
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a;
        }
        return isMinus ? 1 / result : result;
    }

    static double sqrt(int a) {
        double result = 1;
        for (int i = 0; i < 10; i++) {
            result = (result + (a / result)) / 2;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(" ===제곱=== ");
        System.out.println(Math.pow(2, 3));
        System.out.println(Math.pow(2, -3));
        System.out.println(Math.pow(2, 30));
        System.out.println(" ===커스텀=== ");
        System.out.println(pow(2, 3));
        System.out.println(pow(2, -3));
        System.out.println(pow(2, 30));

        System.out.println(" ===제곱근=== ");
        System.out.println(Math.sqrt(16));
        System.out.println(Math.sqrt(8));
        //또는
        System.out.println(Math.pow(16, 1.0 / 2));
        System.out.println(" ===커스텀 제곱근=== ");
        System.out.println(sqrt(16));
        System.out.println(sqrt(8));

    }
}
