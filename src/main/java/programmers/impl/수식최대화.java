package programmers.impl;

import java.util.ArrayList;

public class 수식최대화 {
    static char[] prior = {'+', '-', '*'};
    static boolean[] check = new boolean[3];
    static ArrayList<Long> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();
    static long answer;

    public static long solution(String expression) {
        answer = 0;
        extractNumsAndOps(expression);
        dfs(0, new char[3]);
        return answer;
    }

    private static void extractNumsAndOps(String expression) {
        String num = "";
        for (int i = 0; i < expression.length(); i++) {
            if (Character.isDigit(expression.charAt(i))) {
                num += expression.charAt(i);
            } else {
                nums.add(Long.parseLong(num));
                num = "";
                ops.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(num));
    }

    public static long calc(long num1, long num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0;
        }
    }

    public static void dfs(int count, char[] p) {
        if (count == 3) {
            ArrayList<Long> cNums = new ArrayList<>(nums);
            ArrayList<Character> cOps = new ArrayList<>(ops);

            for (int i = 0; i < p.length; i++) {
                for (int j = 0; j < cOps.size(); j++) {
                    if (p[i] == cOps.get(j)) {
                        long res = calc(cNums.remove(j), cNums.remove(j), p[i]);
                        cNums.add(j, res);
                        cOps.remove(j);
                        j--;
                    }
                }
            }
            answer = Math.max(answer, Math.abs(cNums.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!check[i]) {
                check[i] = true;
                p[count] = prior[i];
                dfs(count + 1, p);
                check[i] = false;
            }
        }
    }
}