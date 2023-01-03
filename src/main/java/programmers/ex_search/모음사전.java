package programmers.ex_search;

/**
 * packageName :  programmers.ex_search
 * fileName : 모음사전
 * author :  ddh96
 * date : 2023-01-03 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/84512
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-03                ddh96             최초 생성
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class 모음사전 {
    static public String[] ch = {"A", "E", "I", "O", "U"};

    public static void main(String[] args) {
        모음사전 run = new 모음사전();
        int a = run.solution("AOAOI");
        System.out.println(a);

    }

    public int solution(String word) {
        List<String> list = new ArrayList<>();
        dfs("", 0, list);
        Collections.sort(list);
        return list.indexOf(word) + 1;
    }

    public void dfs(String string, int index, List<String> list) {
        if (index >= 5) {
            return;
        }
        for (String s : ch) {
            String comb = string + s;
            list.add(comb);
            dfs(comb, index + 1, list);
        }
    }

}