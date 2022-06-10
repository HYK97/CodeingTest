package algorithm.sort;

public class QuickSort {
    /**
     * 특정한 값을 기준을 통해서 나누는 알고리즘
     * 첫번째 값으로 피벗을 설정함
     */


    final static int[] arr = {1, 10, 4, 12, 2, 13, 3, 9, 8, 6};

    public static void main(String[] args) {


        quickSort(arr.length - 1, 0);
        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }

    private static void quickSort(int end, int start) {
        if (start >= end) {
            return;
        }
        int i = start + 1;//왼쪽출발
        int j = end; //오른쪽출발
        int key = start;
        int temp;


        while (i <= j) {
            while (i <= end && arr[i] <= arr[key]) {
                i++;
            }
            while (arr[key] <= arr[j] && j > start) {
                j--;
            }
            if (i > j) {
                temp = arr[j];
                arr[j] = arr[key];
                arr[key] = temp;
            } else {
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        quickSort(j - 1, start);
        quickSort(end, j + 1);

    }
}
