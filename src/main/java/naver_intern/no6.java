package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : no6
 * author :  ddh96
 * date : 2022-12-14 
 * description : https://www.acmicpc.net/problem/11399
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        List<Info> data = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            data.add(new Info(i + 1, Integer.parseInt(split[i])));
        }
        Collections.sort(data);
        int result = 0;
        int prevTotal = 0;
        for (int i = 0; i < N; i++) {
            int currentTime = data.get(i).time;
            result += prevTotal + currentTime;
            prevTotal += currentTime;
        }
        System.out.println(result);
    }

    static class Info implements Comparable<Info> {
        int index;
        int time;

        public Info(int index, int time) {
            this.index = index;
            this.time = time;
        }

        @Override
        public int compareTo(Info info) {
            return this.time - info.time;
        }
    }
}
