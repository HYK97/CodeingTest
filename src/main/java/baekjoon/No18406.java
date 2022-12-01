package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  baekjoon
 * fileName : No18406
 * author :  ddh96
 * date : 2022-11-25
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-25                ddh96             최초 생성
 */
public class No18406 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        int middle = N.length() / 2;
        String data1 = N.substring(0, middle);
        String data2 = N.substring(middle);
        int sum1 = Arrays.stream(data1.split("")).mapToInt(Integer::valueOf).sum();
        int sum2 = Arrays.stream(data2.split("")).mapToInt(Integer::valueOf).sum();
        if (sum1 == sum2) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }

    }
}
