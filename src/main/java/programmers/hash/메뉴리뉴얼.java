package programmers.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * packageName :  programmers.hash
 * fileName : 메뉴리뉴얼
 * author :  ddh96
 * date : 2023-02-15
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/72411
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-02-15             ddh96             최초 생성
 */
public class 메뉴리뉴얼 {
    static HashMap<String, Integer> combinationMenu = new HashMap<>();

    public static void main(String[] args) {
        String[] solution = solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4});
        System.out.println(Arrays.toString(solution));
    }

    public static String[] solution(String[] orders, int[] course) {
        List<String> answers = new ArrayList<>();

        for (int i : course) {
            HashMap<String, Integer> data = new HashMap<>();
            for (String order : orders) {
                char[] menus = order.toCharArray();
                Arrays.sort(menus);
                combination(data, new StringBuilder(), menus, 0, i);
            }

            int maxCount = 2;
            List<String> candidates = new ArrayList<>();
            for (String menu : data.keySet()) {
                int count = data.get(menu);
                if (count >= maxCount) {
                    if (count > maxCount) {
                        maxCount = count;
                        candidates.clear();
                    }
                    candidates.add(menu);
                }
            }

            for (String candidate : candidates) {
                answers.add(candidate);
            }
        }

        return answers.stream().sorted().toArray(String[]::new);
    }

    public static void combination(HashMap<String, Integer> data, StringBuilder comb, char[] menus, int index, int length) {
        if (comb.length() == length) {
            String menu = comb.toString();
            data.put(menu, data.getOrDefault(menu, 0) + 1);
            return;
        }
        if (index == menus.length) {
            return;
        }

        combination(data, comb.append(menus[index]), menus, index + 1, length);
        comb.setLength(comb.length() - 1);
        combination(data, comb, menus, index + 1, length);
    }
}
