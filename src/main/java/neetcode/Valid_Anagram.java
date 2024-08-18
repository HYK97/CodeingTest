package neetcode;

public class Valid_Anagram {
    public boolean isAnagram(String s, String t) {
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for (char c : sChar) {
            sArray[c-97]++;
        }
        for (char c : tChar) {
            tArray[c-97]++;
        }
        for (int i = 0; i < sArray.length; i++) {
            if (sArray[i] != tArray[i]) {
                return false;
            }
        }
        return true;
    }
}