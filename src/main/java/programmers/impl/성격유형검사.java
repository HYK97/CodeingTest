package programmers.impl;

import java.util.HashMap;

/**
 * packageName :  programmers.impl
 * fileName : 성격유형검사
 * author :  ddh96
 * date : 2023-01-04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-04                ddh96             최초 생성
 */
public class 성격유형검사 {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> map = new HashMap<>();
        int length = survey.length;
        for (String s : survey) {
            String[] sp = s.split("");
            map.put(sp[0], 0);
            map.put(sp[1], 0);
        }

        for (int i = 0; i < length; i++) {
            String[] sp = survey[i].split("");
            if (choices[i] < 4) {
                int sum = 4 - choices[i];
                map.put(sp[0], map.get(sp[0]) + sum);
            }
            if (choices[i] > 4) {
                int sum = choices[i] - 4;
                map.put(sp[1], map.get(sp[1]) + sum);
            }
        }

        if (map.get("R").equals(map.get("T"))) {
            sb.append("R");
        } else {
            sb.append(map.get("R") > map.get("T") ? "R" : "T");
        }

        if (map.get("C").equals(map.get("F"))) {
            sb.append("C");
        } else {
            sb.append(map.get("C") > map.get("F") ? "C" : "F");
        }

        if (map.get("J").equals(map.get("M"))) {
            sb.append("J");
        } else {
            sb.append(map.get("J") > map.get("M") ? "J" : "M");
        }

        if (map.get("A").equals(map.get("N"))) {
            sb.append("A");
        } else {
            sb.append(map.get("A") > map.get("N") ? "A" : "N");
        }

        return answer;
    }
}
