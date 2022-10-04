package algorithm.binarysearch;

public class EasyBinarySearchByWhile {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int calCount = 0;
        int searchPoint = 8;
        int start = 0;
        int end = data.length - 1;
        int middle = (start + end) / 2;
        boolean check = false;

        while (start <= end) {
            middle = (end + start) / 2;
            if (data[middle] < searchPoint) {
                start = middle + 1;
                calCount++;
            } else if (data[middle] > searchPoint) {
                end = middle - 1;
                calCount++;
            } else if (data[middle] == searchPoint) {
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("calCount = " + calCount);
        } else {
            System.out.println("calCount = " + -1);
        }
    }
}
