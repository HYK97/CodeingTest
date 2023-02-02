package quiz;

import java.util.Arrays;

/**
 * The type 최대가격구하기.
 */
public class 최대가격구하기 {

    /**
     * @param start 알바시간
     * @param end 알바끝나는시간
     * @param price 가격
     * @return the int
     * 겹치지않는시간 으로 최대 가격 구하기
     */

    public static int solution(int[] start, int[] end, int[] price) {
        int n = start.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = end[i];
            jobs[i][1] = start[i];
            jobs[i][2] = price[i];
        }
        Arrays.sort(jobs, (entry1, entry2) -> {
            if (entry1[0] > entry2[0])
                return 1;
            else
                return -1;
        });
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            dp[i] = jobs[i][2];
            for (int j = 0; j < i; j++) {
                if (jobs[j][0] <= jobs[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + jobs[i][2]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] start = {1, 5, 1, 7};
        int[] end = {5, 7, 10, 10};
        int[] price = {10, 10, 100, 150};
        System.out.println(solution(start, end, price));
    }
}
