package algorithm.sort;

public class QuickSort {
    /**
     * 특정한 값을 기준을 통해서 나누는 알고리즘
     * 첫번째 값으로 피벗을 설정함
     */


    final static int[] arr = {1, 10, 4, 12, 2, 13, 3, 9, 8, 6};

    public static void main(String[] args) {


        quickSort(0, arr.length - 1);
        for (int i : arr) {
            System.out.println("i = " + i);
        }

    }

    private static void quickSort(int start, int end) {
        if (start >= end) {
            return;
        }
        int left = start + 1;
        int right = end;
        int pivot = start;//-> arr index
        int temp;
        while (left <= right) {
            while (left <= end && arr[left] <= arr[pivot]) {
                left++;
            }
            while (right > start && arr[right] >= arr[pivot]) {
                right--;
            }
            if (left > right) {
                //right이 작은값임 바뀌었기때문에
                temp = arr[pivot];
                arr[pivot] = arr[right];
                arr[right] = temp;
            } else {
                temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }

        //바꿧을때 right는 피벗이였으므로 이미 정렬된값이기때문에 이값을빼고
        // 기준으로 나뉨 즉 start ~ right -1 / right +1 ~ end; 까지 다시비교해야댐
        quickSort(start, right - 1);
        quickSort(right + 1, end);


    }
}
