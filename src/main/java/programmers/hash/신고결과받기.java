package programmers.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * packageName :  programmers.hash
 * fileName : 신고결과받기
 * author :  ddh96
 * date : 2023-01-14
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-14                ddh96             최초 생성
 */
public class 신고결과받기 {
    public static void main(String[] args) {

    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, Integer> reportCount = new LinkedHashMap<>();
        Map<String, List<String>> reporterList = new LinkedHashMap<>();
        for (String s : id_list) {
            reportCount.put(s, 0);
            reporterList.put(s, new ArrayList<>());
        }
        for (String s : report) {
            String[] split = s.split(" ");
            String reporter = split[0];
            String personReported = split[1];
            if (!reporterList.get(reporter).contains(personReported)) {
                reporterList.get(reporter).add(personReported);
                reportCount.put(personReported, reportCount.get(personReported) + 1);
            }
        }
        List<String> banList = new ArrayList<>();
        for (String s : reportCount.keySet()) {
            if (reportCount.get(s) >= k) {
                banList.add(s);
            }
        }
        int index = 0;
        for (String s1 : reporterList.keySet()) {
            for (String s : banList) {
                if (reporterList.get(s1).contains(s)) {
                    answer[index]++;
                }
            }
            index++;
        }
        return answer;
    }


}
