package leetcode.learn;

import java.util.Arrays;
import java.util.HashMap;

public class No383 {
    public boolean sol1(String ransomNote, String magazine) {
        HashMap<String,Integer> map =new HashMap<>();
        String[] magazineSplit = magazine.split("");
        for (String s : magazineSplit) {
            map.merge(s, 1, Integer::sum);
        }

        String[] ransomNoteSplit = ransomNote.split("");
        for (String s : ransomNoteSplit) {
            if (map.get(s) == null || map.get(s) == 0) {
                return false;
            } else {
                map.put(s,map.get(s)-1);
            }
        }
        return true;
    }

    public boolean sol2(String ransomNote, String magazine) {
        Integer[] alphabetArray = new Integer[26];
        Arrays.fill(alphabetArray, 0);
        char[] magazineCharArray = magazine.toCharArray();
        for (char s : magazineCharArray) {
            alphabetArray[s-97]++;
        }

        char[] ransomNoteCharArray = ransomNote.toCharArray();
        for (char s : ransomNoteCharArray) {
            if (alphabetArray[s - 97] == 0) {
                return false;
            } else {
                alphabetArray[s - 97]--;
            }
        }
        return true;
    }
}
