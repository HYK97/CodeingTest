package math.combination;

/**
 * packageName :  math.combination
 * fileName : Practice1
 * author :  ddh96
 * date : 2022-12-02
 * description : 조합
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class Practice1 {
    public static void main(String[] args) {
        int n = 4;
        int r = 2;
        Practice1 practice1 = new Practice1();
        System.out.println("조합 = " + practice1.combination(n, r));

        n = 2;
        r = 3;
        System.out.println("중복조합 = " + practice1.combination(n + r - 1, r));

    }

    public int combination(int n, int r) {
        int pResult = 1;
        for (int i = n; i >= n - r + 1; i--) {
            pResult *= i;
        }
        int rResult = 1;
        for (int i = 1; i <= r; i++) {
            rResult *= i;
        }
        return pResult / rResult;
    }
}
