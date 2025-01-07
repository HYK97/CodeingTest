package neetcode;

import java.util.HashSet;

public class Is_ValidSudoku {
    public static void main(String[] args) {
        Is_ValidSudoku isValidSudoku = new Is_ValidSudoku();

    }

    public boolean isValidSudoku(char[][] board) {
        boolean row = rowVerification(board);
        boolean col = columnVerification(board);
        boolean squared = squareVerification(board);
        return row && col && squared;
    }


    private boolean rowVerification(char[][] board) {
        for (char[] chars : board) {
            HashSet<Character> intSet = new HashSet<>();
            for (char row : chars) {
                if (row == '.') {
                    continue;
                }
                if (intSet.contains(row)) {
                    return false;
                }
                intSet.add(row);
            }
        }
        return true;
    }

    private boolean columnVerification(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            HashSet<Character> intSet = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                char row = board[j][i];
                if (row == '.') {
                    continue;
                }
                if (intSet.contains(row)) {
                    return false;
                }
                intSet.add(row);
            }
        }
        return true;
    }

    private boolean squareVerification(char[][] board) {
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                HashSet<Character> intSet = new HashSet<>();
                for (int j = c; j < c + 3; j++) {
                    for (int k = r; k < r + 3; k++) {
                        char row = board[j][k];
                        if (row == '.') {
                            continue;
                        }
                        if (intSet.contains(row)) {
                            return false;
                        }
                        intSet.add(row);
                    }
                }
            }
        }
        return true;
        /*for (int square = 0; square < 9; square++) {
            Set<Character> seen = new HashSet<>();
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int row = (square / 3) * 3 + i;
                    int col = (square % 3) * 3 + j;
                    if (board[row][col] == '.') continue;
                    if (seen.contains(board[row][col])) return false;
                    seen.add(board[row][col]);
                }
            }
        }*/
    }

}
