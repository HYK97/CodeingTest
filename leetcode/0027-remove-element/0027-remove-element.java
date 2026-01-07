class Solution {
    public int removeElement(int[] nums, int val) {
        int right=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=val){
                nums[right]=nums[i];
                right++;
            }
        }
        return k;
}