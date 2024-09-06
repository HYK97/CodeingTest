package neetcode;

import java.lang.reflect.Array;
import java.util.*;

public class Anagram_Groups {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Anagram_Groups a = new Anagram_Groups();
        System.out.println("a = " + a.groupAnagrams(strs));

    }

    /*모든 문자열을 정렬한뒤에 비교해서 푸는 방법도 있다 시간복잡도가 좀 더 올라감*/

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] ints = new int[26];
            char[] charArray = str.toCharArray();
            for (char c : charArray) {
                ints[c - 97]++;
            }
            String key = "";
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt == 0) {
                    continue;
                }
                for (int i = 0; i < anInt; i++) {
                    key += (char) (j + 97);
                }
            }
            System.out.println("key = " + key);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(str);
                map.put(key, newList);
            }
        }
        for (List<String> value : map.values()) {
            result.add(value);
        }
        return result;
    }
}