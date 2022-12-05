package math.quiz;

import java.util.Arrays;

/**
 * packageName :  math.quiz
 * fileName : PermutationQuiz
 * author :  ddh96
 * date : 2022-12-03
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-03                ddh96             최초 생성
 */
public class PermutationQuiz {

    public static void main(String[] args) {
        int[] data = {5, 7, 3, 6, 6};
        solution(data);
        System.out.println("Arrays.toString(data) = " + Arrays.toString(data));
    }

    private static void swap(int[] arr, int idx, int i) {
        int temp;
        temp = arr[idx];
        arr[idx] = arr[i];
        arr[i] = temp;
    }

    static void solution(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int idx = -1;
        for (int i = arr.length - 1; i >= 1; i--) {
            if (arr[i] < arr[i - 1]) {
                idx = i - 1;
                break;
            }
        }

        if (idx == -1) {
            return;
        }
        for (int i = arr.length - 1; i > idx; i--) {
            if (arr[idx] > arr[i] && arr[i] != arr[i - 1]) {
                swap(arr, idx, i);
                break;
            }
        }


    }
}
