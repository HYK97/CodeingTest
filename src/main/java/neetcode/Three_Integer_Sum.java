package neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Integer_Sum {
    public static void main(String[] args) {
        Three_Integer_Sum threeIntegerSum = new Three_Integer_Sum();
        List<List<Integer>> lists = threeIntegerSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println("lists = " + lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) { // 중복제거코드
                continue;
            }
            int sum = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int tempSum = sum + nums[start] + nums[end];
                if (tempSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    while(start < end && nums[start] == nums[start - 1]) { // 중복제거코드
                        start++;
                    }
                } else if (tempSum > 0) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return result;
    }
}