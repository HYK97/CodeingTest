package algorithm.binarysearch;

public class EasyBinarySearchByRecursion {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int calCount = 0;
        int searchPoint = 4;
        int start = 0;
        int end = data.length - 1;
        int middle = (start + end) / 2;
        calCount = binarySearch(start, middle, end, data, calCount, searchPoint);
        System.out.println("calCount = " + calCount);
    }

    public static int binarySearch(int start, int middle, int end, int[] data, int count, int searchPoint) {
        if (start > end) {
            return -1;
        }
        middle = (start + end) / 2;
        if (data[middle] == searchPoint) {
            return count;
        } else if (data[middle] > searchPoint) {
            end = middle - 1;
            return binarySearch(start, middle, end, data, ++count, searchPoint);
        } else {
            start = middle + 1;
            return binarySearch(start, middle, end, data, ++count, searchPoint);
        }
    }
}
