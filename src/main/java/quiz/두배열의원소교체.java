package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class 두배열의원소교체 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int N = Integer.parseInt(split[0]);
        int K = Integer.parseInt(split[1]);
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        String[] sA = br.readLine().split(" ");
        String[] sB = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            A[i] = Integer.valueOf(sA[i]);
            B[i] = Integer.valueOf(sB[i]);
        }
        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        for (int i = 0; i < K; i++) {
            A[i] = B[i];
        }

        int sum = 0;
        for (int a : A) {
            sum += a;
        }
        System.out.println(sum);


    }
}
