package naver_intern;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * packageName :  naver_intern
 * fileName : no1
 * author :  ddh96
 * date : 2022-12-13 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/12906
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-13                ddh96             최초 생성
 */
public class no1 {
    public static void main(String[] args) {
        int[] solution = solution(new int[] {1, 1, 3, 3, 0, 1, 1});
        System.out.println();
    }

    public static int[] solution(int[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        for (Integer integer : arr) {
            queue.add(integer);
        }
        List<Integer> list = new ArrayList<>();
        int prevValue = -1;
        while (!queue.isEmpty()) {
            Integer currentValue = queue.poll();
            if (list.size() == 0) {
                prevValue = currentValue;
                list.add(currentValue);
                continue;
            }
            if (prevValue != currentValue) {
                prevValue = currentValue;
                list.add(currentValue);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

}
