package programmers.impl;

/**
 * packageName :  programmers.impl
 * fileName : 영어끝말잇기
 * author :  ddh96
 * date : 2023-01-03 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/12981
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-03                ddh96             최초 생성
 */

import java.util.HashSet;

class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {

        HashSet<String> data = new HashSet<>();
        int count = 2;
        int turn = 1;
        boolean lose = false;
        String postString = words[0].split("")[words[0].length() - 1];
        data.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (data.contains(words[i])) {
                lose = true;
                break;
            }
            if (!postString.equals(words[i].split("")[0])) {
                lose = true;
                break;
            }

            data.add(words[i]);
            count++;
            postString = words[i].split("")[words[i].length() - 1];
            if (count > n) {
                turn++;
                count = 1;
            }

        }
        if (lose) {
            return new int[] {count, turn};
        }

        return new int[] {0, 0};
    }
}
