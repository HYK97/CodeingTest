package naver_intern;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : no11
 * author :  ddh96
 * date : 2022-12-14 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42746?language=java
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no11 {
    public static void main(String[] args) {
        String solution = solution(new int[] {0, 0, 0, 0});
        System.out.println(solution);
    }

    //사전순서로 정렬
    public static String solution(int[] numbers) {
        //String[] strings = Arrays.stream(numbers).mapToObj(String::valueOf).toArray(String[]::new);
        List<String> a = new ArrayList<>();
        for (int number : numbers) {
            a.add(String.valueOf(number));
        }
        long count = a.stream().filter(i -> i.equals("0")).count();
        if (count == a.size()) {
            return "0";
        }
        //i 와 j 의 크기를 비교할떄 i+j 가크면 i가 큰것 j+i 가크면 j가 큰것
        // 3+30  을 더했을때  30+3 보다 크기 때문에 3이 앞으로감.
        //Arrays.sort(strings, (j + i).compareTo(i + j));
        //3, 30, 34, 5, 9
        //330 >  303
        a.sort((i, j) -> (j + i).compareTo(i + j));
        return String.join("", a);
    }
}
