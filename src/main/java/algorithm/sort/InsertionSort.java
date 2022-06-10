package algorithm.sort;

public class InsertionSort {


    public static void main(String[] args) {

        final int[] arr = {1, 4, 5, 3, 2, 6, 8, 7, 9, 10, 12, 11, 15, 13, 12, 23, 54, 33, 44, 55, 66, 16, 53, 66, 74, 65};
        int temp, i, j;

        for (i = 0; i < arr.length - 1; i++) {
            j = i;
            System.out.println("현재 선택한 값 arr[" + i + "] = " + arr[i]);

            while (arr[j] > arr[j + 1]) {
                System.out.println("현재 j 값 = " + j);
                System.out.println("비교 arr[" + j + "] = " + arr[j] + ">  arr[" + arr[j + 1] + "] = " + arr[j + 1]);
                temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                j--;
            }


        }

    }
}
