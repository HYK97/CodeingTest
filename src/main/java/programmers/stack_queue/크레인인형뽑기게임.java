package programmers.stack_queue;

import java.util.Stack;

/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class 크레인인형뽑기게임 {
    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int random = -1;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int move : moves) {
            Integer doll = getDoll(board, move - 1);
            if (doll == 0) {

            }
            Integer peek = stack.peek();
            if (doll.equals(peek)) {
                stack.pop();
                answer += 2;
                continue;
            }
            stack.push(doll);
        }
        Integer residual = null;
        if (!stack.isEmpty()) {
            residual = stack.pop();
        }

        return answer;
    }

    public static void main(String[] args) {
        int solution = solution(
            new int[][] {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 4, 4, 0}, {1, 2, 2, 1}},
            new int[] {2, 3, 1, 4, 2, 3});
        System.out.println("solution = " + solution);
    }

    public static Integer getDoll(int[][] board, int move) {
        int length = board.length;
        int result = 0;
        for (int i = 0; i < length; i++) {
            if (board[i][move] != 0) {
                result = board[i][move];
                board[i][move] = 0;
                break;
            }
        }
        return result;
    }
}
