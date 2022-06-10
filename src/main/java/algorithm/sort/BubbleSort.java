package algorithm.sort;

public class BubbleSort {


    public static void main(String[] args) {

        final int[] arr = {1, 4, 5, 3, 2, 6, 8, 7, 9, 10, 12, 11, 15, 13, 12, 23, 54, 33, 44, 55, 66, 16, 53, 66, 74, 65};
        int temp;


        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length - 1 - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }

    }
}
