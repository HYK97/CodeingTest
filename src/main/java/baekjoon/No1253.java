package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class No1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        int[] sorted = Arrays.stream(data).sorted().toArray();

        int count = 0;

        for (int i = 0; i < N; i++) {
            int target = sorted[i];
            int s = 0;
            int e = N - 1;
            while (s < e) {
                int sum = sorted[s] + sorted[e];
                if (target == sum) {
                    if (s != i && e != i) {
                        count++;
                        break;
                    } else if (e == i) {
                        e--;
                    } else if (s == i) {
                        s++;
                    }
                } else if (target > sum) {
                    s++;
                } else if (sum > target) {
                    e--;
                }
            }
        }

        System.out.println(count);

    }
}
