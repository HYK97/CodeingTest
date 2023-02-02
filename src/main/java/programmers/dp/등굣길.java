package programmers.dp;

/**
 * packageName :  programmers.dp
 * fileName : 등굣길
 * author :  ddh96
 * date : 2023-02-03 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-02-03                ddh96             최초 생성
 */

public class 등굣길 {
    public static void main(String[] args) {
        solution(5, 5, new int[][] {{2, 2}, {2, 3}});
    }

    public static int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] dp = new int[n + 1][m + 1];
        dp[1][1] = 1;

        if (puddles[0].length > 0) {
            for (int[] puddle : puddles) {
                dp[puddle[0]][puddle[1]] = -1;
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == 1 && i == 1) {
                    continue;
                }
                if (dp[j][i] == -1) {
                    dp[j][i] = 0;
                } else {
                    dp[j][i] = (dp[j - 1][i] + dp[j][i - 1]) % mod;

                }
            }
        }
        return dp[n][m];
    }
}
