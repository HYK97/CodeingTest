package programmers.stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 * packageName :  programmers.stack_queue
 * fileName : 괄호회전하기
 * author :  ddh96
 * date : 2023-03-29 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/76502
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-29                ddh96             최초 생성
 */
public class 괄호회전하기 {
    public static int solution(String s) {
        int answer = 0;
        ArrayDeque<String> queue = new ArrayDeque<>();
        String[] split = s.split("");
        Collections.addAll(queue, split);
        int length = queue.size();

        for (int i = 0; i < length; i++) {
            queue.addLast(queue.pollFirst());
            boolean b = stackStart(queue.toArray(new String[0]));
            if (b) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean stackStart(String[] data) {
        System.out.println("Arrays.toString(data) = " + Arrays.toString(data));
        Stack<String> stack = new Stack<>();
        for (String s : data) {
            if (s.equals("(") || s.equals("{") || s.equals("[")) {
                stack.push(s);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String pop = stack.pop();
                System.out.println("pop = " + pop);
                System.out.println("s = " + s);
                if (s.equals(")") && !pop.equals("(")) {
                    return false;
                }
                if (s.equals("}") && !pop.equals("{")) {
                    return false;
                }
                if (s.equals("]") && !pop.equals("[")) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int solution = solution("{{{}");
        System.out.println("solution = " + solution);
    }
}
