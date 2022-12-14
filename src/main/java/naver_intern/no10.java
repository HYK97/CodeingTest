package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  naver_intern
 * fileName : no10
 * author :  ddh96
 * date : 2022-12-14 
 * description :https://www.acmicpc.net/problem/2467
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N];
        Arrays.sort(data);
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(split[i]);
        }
        int minGap = Integer.MAX_VALUE;
        int left = 0;
        int right = N - 1;

        while (left == right) {
            int leftValue = data[left];

            int rightValue = data[right];

        }

        System.out.println(Arrays.toString(data));

    }

}
