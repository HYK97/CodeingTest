package programmers.graph;

import java.util.Arrays;

/**
 * packageName :  programmers.graph
 * fileName : 순위
 * author :  ddh96
 * date : 2023-01-24
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/49191
 * 그래프이미지 : https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2Fcqwz0v%2FbtrkGHgXuEN%2FqepJXxLyPK5yyF58xMO0C1%2Fimg.png
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-24                ddh96             최초 생성
 */
public class 순위 {
    public static void main(String[] args) {
        solution(5, new int[][] {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}});
    }

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] table = new int[n + 1][n + 1];
        for (int[] ints : table) {
            Arrays.fill(ints, 999);
        }
        for (int i = 0; i < results.length; i++) {
            table[results[i][0]][results[i][1]] = 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (i == j) {
                        continue;
                    }
                    table[i][j] = Math.min(table[i][j], table[i][k] + table[k][j]);
                }
            }
        }

        for (int[] ints : table) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

        for (int i = 1; i <= n; i++) {
            int count = 0;
            for (int j = 1; j <= n; j++) {
                System.out.println(
                    "i=" + i + " j=" + j + " table[i][j]=" + table[i][j] + " table[j][i]=" + table[j][i]);
                if (table[j][i] != 999 || table[i][j] != 999) {
                    count++;
                }
                System.out.println("count = " + count);
            }
            System.out.println("i=" + i + "==============count=============" + count);
            if (count == n - 1) {
                answer++;
            }
        }

        System.out.println("answer = " + answer);

        return answer;
    }
}