package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * packageName :  naver_intern
 * fileName : no8
 * author :  ddh96
 * date : 2022-12-14 
 * description :https://www.acmicpc.net/problem/2075
 * 해결 아이디어 heap 은 항상 내부의 값을 정렬시켜주기때문에
 * 최대힙을 구성해서 n번째의 큰수를 구한것.
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split(" ");
            for (String s : split) {
                queue.offer(Integer.valueOf(s));
            }
        }
        for (int i = 0; i < N - 1; i++) {
            queue.poll();
        }
        System.out.println(queue.poll());
    }
}
