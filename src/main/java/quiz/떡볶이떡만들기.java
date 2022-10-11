package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 떡볶이떡만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int start = 0;
        int end = Arrays.stream(data).max().getAsInt();
        int middle = 0;
        int result = 0;
        while (start <= end) {
            long sum = 0;
            middle = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                if (data[i] > middle) {
                    sum += data[i] - middle;
                }
            }
            if (sum < M) {
                end = middle - 1;
            } else {
                result = middle;
                start = middle + 1;
            }
        }
        System.out.println("result = " + result);
    }
}
