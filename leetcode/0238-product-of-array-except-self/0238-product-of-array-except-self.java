class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] result = new int [nums.length];
        int tmp = 1;
        for (int i = 0 ; i < nums.length ; i++){
            if (i == 0){
                result[i] = 1;
                continue;
            }
            result[i] = result[i-1] * nums[i-1];
        }

        for (int i = nums.length - 2 ; i >= 0 ; i--){
            tmp = tmp * nums[i+1];
            result[i] = tmp * result[i];
        }
        return result;
    }
}