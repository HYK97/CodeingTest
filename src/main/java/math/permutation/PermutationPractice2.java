package math.permutation;

import java.util.Arrays;

/**
 * packageName :  math.permutation
 * fileName : PermutationPractice2
 * author :  ddh96
 * date : 2022-12-02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class PermutationPractice2 {

    public static void main(String[] args) {
        PermutationPractice2 p = new PermutationPractice2();
        int n = 4;
        int r = 3;
        int[] arr = {1, 2, 3, 4};
        boolean[] visited = new boolean[n];
        int[] out = new int[r];
        p.permutation(arr, 0, n, r, visited, out);
    }

    void permutation(int[] arr, int depth, int n, int r, boolean[] visited, int[] out) {
        if (depth == r) {
            System.out.println(Arrays.toString(out));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, n, r, visited, out);
                visited[i] = false;
            }
        }
    }
}
