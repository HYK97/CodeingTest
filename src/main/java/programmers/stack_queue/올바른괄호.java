package programmers.stack_queue;

import java.util.Deque;
import java.util.LinkedList;

public class 올바른괄호 {
    public static void main(String[] args) {

        System.out.println(solution("(())()"));

    }

    static boolean solution(String s) {

        char[] splitData = s.toCharArray();
        Deque<Character> que = new LinkedList<>();
        for (char splitDatum : splitData) {
            que.add(splitDatum);
        }
        int length = que.size();

        int left = 0;
        int right = 0;
        if ((que.peekFirst() != null && que.peekFirst() == ')') || (que.peekLast() != null && que.peekLast() == '(')) {
            return false;
        }


        for (int i = 0; i < length; i++) {
            if (que.peekFirst() != null && que.pollFirst().equals(')')) {
                right++;
            } else {
                left++;
            }
            if (right == left) {
                if (que.peekFirst() != null && que.peekFirst().equals(')')) {
                    return false;
                }
            }
        }

        return right == left;
    }
}
