package priv;

/*
*
*
*
A string made of an even number of characters ("<" and/or ">") is called symmetric if all characters in its first half are "<" and all characters in its second half are ">". Examples of symmetric strings are: (empty string), "<>", "<<>>", "<<<>>>>", etc.
Write a function:
class Solution { public int solution(String S); }
that, given a string S made of N characters ("<", ">" and/or "?")", returns the length of the longest symmetric
substring that can be obtained after replacing question marks with "<<" or ">" characters.
Examples:
1. For S = "<??>>", after replacing all question marks with "<", the string "<<<>>" is obtained. Its longest symmetric substring is "<<>>", so the function should return 4.
2. For S = "??????", the optimal option is to replace the first three question marks with "<" and the next three question marks with ">", thus obtaining the string " <<<>>>". The function should return 6.
3. For S = "<<<?", the function should return 2.
Write an efficient algorithm for the following assumptions:
⚫ the length of string S is within the range [1..200,000];
⚫ string S is made only of the following characters: <<','>' and/or '?'.
Copyright 2009-2023 by Codility Limited. All Rights Reserved.
Unauthorized copying, publication or disclosure prohibited.
*
* */
public class 문제5 {

    public static void main(String[] args) {
        문제5 sol = new 문제5();
        System.out.println(sol.solution("<??>>"));
        System.out.println(sol.solution("??????"));
        System.out.println(sol.solution("<<<?"));
        System.out.println(sol.solution("?<???<<?"));
        System.out.println(sol.solution("??<>?<<>>"));
        System.out.println(sol.solution("<"));
        System.out.println(sol.solution("??<>?<<>>"));
        System.out.println(sol.solution("<<<<<<<<<?>>>>>>>>"));
        System.out.println(sol.solution("<<<>><<>>>"));

    }

    public int solution(String S) {
        //투포인터 테스트
        int answer = 0;
        for (int i = 0; i < S.length(); i++) {
            int left = i;
            int right = i + 1;
            int leftQueue = 0;
            int rightQueue = 0;
            while (left >= 0 && right < S.length()) {
                char leftChar = S.charAt(left);
                if (!(leftChar == '<' || leftChar == '?')) {
                    break;
                }
                char rightChar = S.charAt(right);
                if (!(rightChar == '>' || rightChar == '?')) {
                    break;
                }
                if (leftChar == '?') {
                    leftQueue++;
                }
                if (rightChar == '?') {
                    rightQueue++;
                }
                if (leftQueue > right - i || rightQueue > i + 1) {
                    break;
                }
                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }
        }
        return answer;
    }
}