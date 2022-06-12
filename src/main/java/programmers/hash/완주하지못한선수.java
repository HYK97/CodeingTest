package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 완주하지못한선수 {


    public static void main(String[] args) {
        String solution = solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
        System.out.println("solution = " + solution);

    }

    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (!map.containsKey(participant[i])) {
                map.put(participant[i], 1);
            } else {
                Integer count = map.get(participant[i]);
                map.put(participant[i], ++count);
            }
        }
        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                Integer count = map.get(completion[i]);
                count--;
                map.put(completion[i], count);
            }
        }
        for (String s : map.keySet()) {
            if (map.get(s) > 0) {
                answer = s;
            }
        }
        return answer;
    }

}
