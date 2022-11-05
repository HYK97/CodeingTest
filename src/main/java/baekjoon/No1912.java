package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  baekjoon
 * fileName : No1912
 * author :  ddh96
 * date : 2022-11-05
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-05                ddh96             최초 생성
 */
public class No1912 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] table = new int[data.length];
        table[0] = data[0];
        for (int i = 1; i < n; i++) {
            table[i] = Math.max(data[i], table[i - 1] + data[i]);
        }
        int max = Arrays.stream(table).max().getAsInt();
        System.out.println(max);
    }


}
