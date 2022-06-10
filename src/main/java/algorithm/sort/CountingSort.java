package algorithm.sort;

public class CountingSort {

    public static void main(String[] args) {
        int[] count = new int[5];
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;
        }
        int[] data = {1, 2, 3, 4, 5, 1, 2, 3, 2, 3, 2, 4, 5, 1, 2, 3, 2, 4, 4, 2, 2, 3, 3, 3};
        for (int i = 0; i < data.length; i++) {
            count[data[i] - 1]++;
        }
        for (int i = 0; i < count.length; i++) {
            for (int j = 0; j < count[i]; j++) {
                System.out.println(i + 1);
            }

        }
    }
}
