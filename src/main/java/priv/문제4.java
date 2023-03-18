package priv;

public class 문제4 {
    public static void main(String[] args) {
        문제4 sol = new 문제4();
        System.out.println(sol.solution("acascac")); // Output: 1
        System.out.println(sol.solution("acac")); // Output: 2
        System.out.println(sol.solution("sxscacaxd")); // Output: 0
    }

    public int solution(String S) {

        int[] alphabet = new int[26];
        for (char c : S.toCharArray()) {
            alphabet[c - 'a']++;
        }
        int delete = 0;

        for (int count : alphabet) {
            if (count % 2 == 1) {
                delete++;
            }
        }
        return delete;
    }
}