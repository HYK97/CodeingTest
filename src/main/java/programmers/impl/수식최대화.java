package programmers.impl;

import java.util.ArrayList;

public class 수식최대화 {
    private static final char[] PRIORITY_OPERATORS = {'+', '-', '*'};
    private static boolean[] operatorUsed = new boolean[3];
    private static ArrayList<Long> numbers = new ArrayList<Long>();
    private static ArrayList<Character> operators = new ArrayList<Character>();
    private static long maxAnswer;

    private static Long performOperation(Long num1, Long num2, char op) {
        switch (op) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
            default:
                return 0L;
        }
    }

    private static void calculateMaxExpressionHelper(int count, char[] operatorsInOrder) {
        if (count == 3) {
            ArrayList<Long> currentNumbers = new ArrayList<>(numbers);
            ArrayList<Character> currentOperators = new ArrayList<Character>(operators);

            for (int i = 0; i < operatorsInOrder.length; i++) {
                for (int j = 0; j < currentOperators.size(); j++) {
                    if (operatorsInOrder[i] == currentOperators.get(j)) {
                        Long result = performOperation(currentNumbers.remove(j), currentNumbers.remove(j),
                            operatorsInOrder[i]);
                        currentNumbers.add(j, result);
                        currentOperators.remove(j);
                        j--;
                    }
                }
            }
            maxAnswer = Math.max(maxAnswer, Math.abs(currentNumbers.get(0)));
            return;
        }

        for (int i = 0; i < 3; i++) {
            if (!operatorUsed[i]) {
                operatorUsed[i] = true;
                operatorsInOrder[count] = PRIORITY_OPERATORS[i];
                calculateMaxExpressionHelper(count + 1, operatorsInOrder);
                operatorUsed[i] = false;
            }
        }
    }

    public long calculateMaxExpression(String expression) {
        maxAnswer = 0;

        String currentNumber = "";
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) >= '0' && expression.charAt(i) <= '9') {
                currentNumber += expression.charAt(i);
            } else {
                numbers.add(Long.parseLong(currentNumber));
                currentNumber = "";
                operators.add(expression.charAt(i));
            }
        }
        numbers.add(Long.parseLong(currentNumber));
        calculateMaxExpressionHelper(0, new char[3]);

        return maxAnswer;
    }
}
