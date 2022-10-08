package quiz;

import java.io.*;
import java.util.Arrays;

public class 부품찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int M = Integer.parseInt(br.readLine());
        int[] data2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < data2.length; i++) {
            //array  , 찾을 수 , 시작index ,종료 index
            if (search(data, data2[i], 0, N - 1)) {
                bw.write("yes ");
            } else {
                bw.write("no ");
            }

        }
        bw.flush();
    }

    private static boolean search(int[] data, int target, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (data[mid] == target) {
                return true;
            }
            //2  3  4  5
            //0  1  2  3
            //     1  2
            if (data[mid] > target) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}
