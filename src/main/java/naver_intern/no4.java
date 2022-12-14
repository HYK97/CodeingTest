package naver_intern;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * packageName :  naver_intern
 * fileName : no4
 * author :  ddh96
 * date : 2022-12-14 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42862
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no4 {
    public static void main(String[] args) {
        int solution1 = solution(7, new int[] {1, 5, 3, 6}, new int[] {6, 2, 4, 7});
        int solution2 = solution(5, new int[] {2, 4}, new int[] {3});
        int solution3 = solution(3, new int[] {3}, new int[] {1});
        int solution4 = solution(6, new int[] {1, 3, 4}, new int[] {2, 3, 5});
        System.out.println("solution1 = " + solution1);
        System.out.println("solution2 = " + solution2);
        System.out.println("solution3 = " + solution3);
        System.out.println(solution4);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> newLost, newReserve, set;
        newLost = Arrays.stream(lost).boxed().collect(Collectors.toSet());
        newReserve = Arrays.stream(reserve).boxed().collect(Collectors.toSet());
        set = new HashSet<>(newReserve);
        set.retainAll(newLost);
        newLost.removeAll(set);
        newReserve.removeAll(set);

        for (int i : newReserve) {
            if (newLost.contains(i - 1)) {
                newLost.remove(i - 1);
            } else if (newLost.contains(i + 1)) {
                newLost.remove(i + 1);
            }
        }

        return n - newLost.size();

    }
}
