package math.combination;

/**
 * packageName :  math.combination
 * fileName : Practice2
 * author :  ddh96
 * date : 2022-12-02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class Practice2 {
    public static void main(String[] args) {
        Practice2 p2 = new Practice2();
        int[] arr = {1, 2, 3, 4};
        int n = 4;
        int r = 3;
        boolean[] visited = new boolean[4];

        p2.combination(arr, visited, 0, n, r);

    }

    void combination(int[] arr, boolean[] visited, int depth, int n, int r) {
        if (r == 0) {
            for (int i = 0; i < n; i++) {
                if (visited[i]) {
                    System.out.print(arr[i]);
                }
            }
            System.out.println();
            return;
        }
        if (depth == n) {
            return;
        }

        visited[depth] = true;
        combination(arr, visited, depth + 1, n, r - 1);

        visited[depth] = false;
        combination(arr, visited, depth + 1, n, r);

    }
}
