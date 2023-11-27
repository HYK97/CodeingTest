
import java.util.Arrays;
import java.util.Scanner;

/**
 * packageName :  baekjoon.array
 * fileName : No3273
 * author :  ddh96
 * date : 2023-11-28 
 * description : https://www.acmicpc.net/problem/3273
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-11-28                ddh96             최초 생성
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String data = sc.nextLine();
        int targetNum= Integer.parseInt(sc.nextLine());
        int[] integerData = Arrays.stream(data.split(" ")).mapToInt(Integer::valueOf).toArray();
        int result=0;
        for (int integerDatum : integerData) {
            if (integerDatum == targetNum) {
                result++;
            }
        }
        System.out.println(result);
    }
}
