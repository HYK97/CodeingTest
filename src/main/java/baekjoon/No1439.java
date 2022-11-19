package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  quiz
 * fileName : 문자열뒤집기
 * author :  ddh96
 * date : 2022-11-20
 * description : 그리디 기초
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-20                ddh96             최초 생성
 */
public class No1439 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] data = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();

        int zero = 0;
        int one = 0;
        int temp = data[0];
        if (temp == 0) {
            zero++;
        } else {
            one++;
        }
        for (int i = 1; i < data.length; i++) {
            if (temp != data[i]) {
                if (data[i] == 0) {
                    zero++;
                } else {
                    one++;
                }
                temp = data[i];
            }
        }
        System.out.println(Math.min(one, zero));
    }
}
