class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 1;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] - prev > k) {
                count++;
                prev = nums[i];
            }
        }
        return count;
    }
}
