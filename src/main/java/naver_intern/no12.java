package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  naver_intern
 * fileName : no12
 * author :  ddh96
 * date : 2022-12-15 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-15                ddh96             최초 생성
 */
public class no12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine().split(" ")[1]);
        int[] preys = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        for (int prey : preys) {
            if (L >= prey) {
                L++;
            } else {
                break;
            }
        }
        System.out.println(L);
    }
}
