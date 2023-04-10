package programmers.dfs_bfs;

/**
 * packageName :  programmers.dfs_bfs
 * fileName : 블루빨강
 * author :  ddh96
 * date : 2023-04-10
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-10                ddh96             최초 생성
 */
public class 블루빨강 {
    private int count = 0;

    public int solution(String S) {
        String[] data = S.split("");
        solve(data, 0, "", "", true);
        return count;
    }

    private void solve(String[] data, int index, String red, String blue, boolean isRed) {
        if (index == data.length) {
            int redData = isValid(red);
            int blueData = isValid(blue);
            if (redData == blueData && redData != -1) {
                count++;
            }
            return;
        }

        String currentData = data[index];

        if (isRed) {
            solve(data, index + 1, red + currentData, blue, true);
            solve(data, index + 1, red + currentData, blue, false);
        } else {
            solve(data, index + 1, red, blue + currentData, true);
            solve(data, index + 1, red, blue + currentData, false);
        }
    }

    private int isValid(String expression) {
        if (expression.isEmpty()) {
            return -1;
        }

        int value = 0;
        int currentNumber = 0;
        char prev = '+';

        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                currentNumber = currentNumber * 10 + (c - '0');
                if (currentNumber >= 100000000) {
                    return -1;
                }
            } else {
                if (prev == '+') {
                    value += currentNumber;
                } else {
                    value -= currentNumber;
                }
                if (value < 0 || value >= 100000000) {
                    return -1;
                }
                currentNumber = 0;
                prev = c;
            }
        }
        if (prev == '+') {
            value += currentNumber;
        } else {
            value -= currentNumber;
        }
        if (value >= 0 && value < 100000000) {
            return value;
        } else {
            return -1;
        }
    }

}