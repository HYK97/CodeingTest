package programmers.greedy;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * packageName :  programmers.greedy
 * fileName : 큰_수_만들기
 * author :  ddh96
 * date : 2023-03-28 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class 큰_수_만들기 {
    public static void main(String[] args) {
        String solution = solution("77777", 1);
        System.out.println("solution = " + solution);
    }

    public static String solution(String number, int k) {
        String answer = "";
        //넘버가 들어있음
        char[] chars = number.toCharArray();
        int length = chars.length - k;
        Stack<Integer> stack = new Stack<>();

        for (char aChar : chars) {
            int zero = aChar - '0';
            if (stack.isEmpty()) {
                stack.push(aChar - '0');
                continue;
            }
            if (k > 0) {
                while (stack.peek() < zero) {
                    stack.pop();
                    k--;
                    if (stack.isEmpty() || k <= 0) {
                        break;
                    }
                }
            }
            stack.push(zero);
        }

        while (stack.size() > length) {
            stack.pop();
        }
        return stack.stream().map(String::valueOf).collect(Collectors.joining());
    }
}
