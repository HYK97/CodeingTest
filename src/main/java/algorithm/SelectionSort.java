package algorithm;

import java.util.Arrays;

public class SelectionSort {


    public static void main(String[] args) {
        final int[] arr = {1, 4, 5, 3, 2, 6, 8, 7, 9, 10,12,11,15,13,12,23,54,33,44,55,66,16,53,66,74,65};

        int min,temp;
        int index = 0;


        for (int j = 0; j < arr.length; j++){
            min=99999;
            //등차수열 n의 제곱 O(N²) 비효율적임.
            for (int i = j; i < arr.length; i++) { //가장작은 값의 값과 index를 저장장
               if (arr[i] < min) {
                    min= arr[i];
                    index =i;
                }
            }
            temp = arr[j];
            arr[j]=arr[index];
            arr[index]=temp;
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
