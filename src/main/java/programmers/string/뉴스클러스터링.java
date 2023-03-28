package programmers.string;

import java.util.HashMap;

/**
 * packageName :  programmers.string
 * fileName : 뉴스클러스터링
 * author :  ddh96
 * date : 2023-03-28 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/17677
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class 뉴스클러스터링 {
    public static void main(String[] args) {
        int solution = solution("E=M*C^2", "E=M*C^2");
        System.out.println(solution);
    }

    public static int solution(String str1, String str2) {
        double answer = 0;
        String[] str1Up = str1.toUpperCase().split("");
        String[] str2Up = str2.toUpperCase().split("");

        HashMap<String, Integer> data2 = new HashMap<>();
        HashMap<String, Integer> data1 = new HashMap<>();

        int point1 = 0;
        int point2 = 1;

        makeMap(str1Up, data1, point1, point2);
        makeMap(str2Up, data2, point1, point2);

        int intersection = 0;
        for (String s : data1.keySet()) {
            if (data2.containsKey(s)) {
                Integer count1 = data1.get(s);
                Integer count2 = data2.get(s);
                intersection += Math.min(count1, count2);
            }
        }
        int merge = 0;
        for (String s : data1.keySet()) {
            Integer count1 = data1.get(s);
            if (data2.containsKey(s)) {
                Integer count2 = data2.get(s);
                merge += Math.max(count1, count2);
            } else {
                merge += count1;
            }
        }
        for (String s : data2.keySet()) {
            if (!data1.containsKey(s)) {
                Integer count1 = data2.get(s);
                merge += count1;
            }
        }
        if (intersection != 0 || merge != 0) {
            answer = ((double)intersection / merge * 65536);
            return (int)answer;
        }
        return 65536;
    }

    private static void makeMap(String[] str1Up, HashMap<String, Integer> data1, int point1, int point2) {
        while (point2 <= str1Up.length - 1) {
            String s = str1Up[point1] + str1Up[point2];
            if (s.matches("^[a-zA-Z]*$")) {
                if (!data1.containsKey(s)) {
                    data1.put(s, 1);
                } else {
                    data1.put(s, data1.get(s) + 1);
                }
            }
            point1 = point2;
            point2++;
        }
    }
}
