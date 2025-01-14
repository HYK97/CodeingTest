package neetcode;

public class Two_Integer_Sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while (start > end) {
            int targetData = numbers[start] + numbers[end];
            if (target == targetData) {
                result[0] = start + 1;
                result[1] = end + 1;
                break;
            }
            if (target > targetData) {
                start++;
                continue;
            }
            if (target < targetData) {
                end--;
            }
        }
        return result;
    }
}
