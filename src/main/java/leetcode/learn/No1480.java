package leetcode.learn;

/*
* https://leetcode.com/problems/running-sum-of-1d-array/
* */
public class No1480 {

    public int[] runningSum(int[] nums) {
        int []result =new int[nums.length];
        result[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i]=result[i-1]+nums[i];
        }
        return result;
    }
}
