package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 일이될때까지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data1 = br.readLine().split(" ");
        int N = Integer.parseInt(data1[0]);
        int K = Integer.parseInt(data1[1]);
        int count = 0;
        while (N >= 1) {
            System.out.println(N);
            if (N % K == 0) {
                N /= K;
                count++;
            } else {
                N--;
                count++;
            }
        }
        System.out.println("count = " + (count - 1));

    }

}
