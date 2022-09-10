package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count1 = Integer.parseInt(br.readLine());
        int[] data1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Set<Integer> set = new HashSet<>();
        for (int i : data1) {
            set.add(i);
        }
        int count2 = Integer.parseInt(br.readLine());
        int[] data2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();

        for (int i = 0; i < count2; i++) {
            if (set.contains(data2[i])) {
                System.out.print(1 + " ");
            } else {
                System.out.print(0 + " ");
            }
        }
    }
}
