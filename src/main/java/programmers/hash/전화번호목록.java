package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 전화번호목록 {
    public static void main(String[] args) {
        solution(new String[]{"119", "97674223", "1195524421"});
    }

    public static boolean solution(String[] phone_book) {
        /*
        HashMap을 이용한 풀이
        */
        Map<String, Integer> map = new HashMap<String, Integer>();
        boolean answer = true;
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], 0);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    answer = false;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
