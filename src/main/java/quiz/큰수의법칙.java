package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 큰수의법칙 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] data1 = br.readLine().split(" ");
        int N = Integer.parseInt(data1[0]);
        int M = Integer.parseInt(data1[1]);
        int K = Integer.parseInt(data1[2]);
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).sorted().toArray();
        int first = data[data.length - 1];
        int second = data[data.length - 2];
        int count = M / (K + 1) * K;
        count += M % (K + 1);
        int result = count * first;
        result += (M - count) * second;
        System.out.println(result);
    }

}
