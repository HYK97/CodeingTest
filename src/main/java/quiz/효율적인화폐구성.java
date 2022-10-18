package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.lang.Math.min;

public class 효율적인화폐구성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] data = new int[N];
        int[] dp = new int[10001];
        Arrays.fill(dp, 99999);
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int element = data[i];
            dp[element] = 1; // 초기값 1부터
            for (int j = element; j <= M; j++) {// element 부터 시작 해서 M 까지 확인하기
                if (dp[j - element] != 99999) {//99999가 아닐경우  -> 즉 만들어질 경우
                    dp[j] = min(dp[j], dp[j - element] + 1); //현재 값과 이전 값에 +1 한값을 비교해서 더작은 쪽의 값을 업데이트함
                }
            }
        }

        if (dp[M] == 99999) {
            System.out.println("-1");
        } else {
            System.out.println(dp[M]);
        }


    }
}
