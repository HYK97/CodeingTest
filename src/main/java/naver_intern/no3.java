package naver_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : no3
 * author :  ddh96
 * date : 2022-12-13 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42840
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-13                ddh96             최초 생성
 */
public class no3 {
    public static void main(String[] args) {

        int[] solution = solution(new int[] {1, 2, 5, 4, 5, 4, 2, 3, 5, 1, 3, 4});
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] answers) {

        Integer[] a = new Integer[] {1, 2, 3, 4, 5};
        Integer[] b = new Integer[] {2, 1, 2, 3, 2, 4, 2, 5};
        Integer[] c = new Integer[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        HashMap<Integer, Integer> index = new LinkedHashMap<>();
        index.put(1, 0);
        index.put(2, 0);
        index.put(3, 0);
        int id = 0;
        for (int k : answers) {
            if (k == a[id]) {
                index.put(1, index.get(1) + 1);
            }
            if (id >= a.length - 1) {
                id = 0;
            } else {
                id++;
            }
        }
        id = 0;
        for (int j : answers) {
            if (j == b[id]) {
                index.put(2, index.get(2) + 1);
            }
            if (id >= b.length - 1) {
                id = 0;
            } else {
                id++;
            }
        }
        id = 0;
        for (int answer : answers) {
            if (answer == c[id]) {
                index.put(3, index.get(3) + 1);
            }
            if (id >= c.length - 1) {
                id = 0;
            } else {
                id++;
            }
        }
        List<Integer> list = new ArrayList<>();
        int maxValue = Integer.MIN_VALUE;
        for (Integer key : index.keySet()) {
            if (maxValue <= index.get(key)) {
                maxValue = index.get(key);
            }
        }
        System.out.println(maxValue);

        for (Integer key : index.keySet()) {
            if (maxValue == index.get(key)) {
                list.add(key);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}
