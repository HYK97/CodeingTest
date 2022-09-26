package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드게임 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data1 = br.readLine().split(" ");
        int N = Integer.parseInt(data1[0]);
        int M = Integer.parseInt(data1[1]);
        int max = 0;
        for (int i = 0; i < N; i++) {
            int min = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).min().getAsInt();
            if (min > max) {
                max = min;
            }
        }
        System.out.println("max = " + max);

    }

}
