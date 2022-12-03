package math.permutation;

/**
 * packageName :  math.permutation
 * fileName : PermutationPractice
 * author :  ddh96
 * date : 2022-12-02
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-02                ddh96             최초 생성
 */
public class PermutationPractice {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};

        PermutationPractice p = new PermutationPractice();
        p.permutation(arr, 0, 4, 3);
    }

    private void permutation(int[] arr, int depth, int n, int r) {

        if (depth == r) {
            for (int i = 0; i < r; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = depth; i < n; i++) {
            swap(arr, depth, i);
            permutation(arr, depth + 1, n, r);
            swap(arr, depth, i);
        }
    }

    void swap(int[] arr, int depth, int index) {
        int temp = arr[depth];
        arr[depth] = arr[index];
        arr[index] = temp;
    }

}

