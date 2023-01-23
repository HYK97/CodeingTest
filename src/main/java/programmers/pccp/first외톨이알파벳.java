package programmers.pccp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * packageName :  programmers.pccp
 * fileName : first외톨이알파벳
 * author :  ddh96
 * date : 2023-01-23 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-23                ddh96             최초 생성
 */
public class first외톨이알파벳 {

    public static void main(String[] args) {
        String aaabnbaa = solution("aaabnbaa");
        System.out.println("aaabnbaa = " + aaabnbaa);
    }

    public static String solution(String input_string) {
        HashMap<String, Integer> map = new HashMap<>();
        String[] split = input_string.split("");
        String prev = split[0];
        for (int i = 1; i < split.length; i++) {
            if (prev.equals(split[i])) { //이전 값과 같은 경우 더하기
                prev = split[i];
            } else { // 아닌경우 prev 초기화 data 초기화
                addMap(map, prev);
                prev = split[i];
            }
        }
        addMap(map, prev);
        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) >= 2) {
                list.add(key);
            }
        }
        if (list.size() == 0) {
            return "N";
        }
        return list.stream().sorted().collect(Collectors.joining());
    }

    private static void addMap(HashMap<String, Integer> map, String data) {
        if (map.containsKey(data)) {
            map.put(data, map.get(data) + 1);
        } else {
            map.put(data, 1);
        }
    }

}
