package algorithm;

public class MergeSort {

    static int count = 0;

    public static void main(String[] args) {
        int array[] = {4, 2, 3, 5, 8, 6, 7, 9};

        mergeSort(array);
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println("count = " + count);

    }

    static void merge(int arr[], int[] temp, int start, int middle, int end) {
        for (int i = start; i <= end; i++) {
            temp[i] = arr[i];
        }
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = start;
        while (leftIndex <= middle && rightIndex <= end) {
            if (temp[leftIndex] <= temp[rightIndex]) {
                arr[index] = temp[leftIndex];
                leftIndex++;
            } else {
                arr[index] = temp[rightIndex];
                rightIndex++;
            }
            index++;
        }
        //남은 데이터 원본 배열에 삽입
        for (int l = 0; l <= middle - leftIndex; l++) {
            arr[index + l] = temp[leftIndex + l];
        }
    }


    static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length];
        mergeSort(arr, temp, 0, arr.length - 1);

    }


    static void mergeSort(int arr[], int[] temp, int start, int end) {
        // 배열의 크기가 1보다큰 경우 배열  [1] [2] [3] [4]
        // 일경우                        n           m  이된다.
        count++;
        if (start < end) {
            int middle = (start + end) / 2;
            mergeSort(arr, temp, start, middle);
            mergeSort(arr, temp, middle + 1, end);
            merge(arr, temp, start, middle, end);
        }
    }


}
