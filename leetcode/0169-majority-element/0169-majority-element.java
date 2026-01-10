class Solution {
    public int majorityElement(int[] nums) {
        int major = 0;
        int count = 0;
        for (int i = 0 ; i < nums.length ; i++){
            if(i == 0){
                major = nums[i];
                count ++;
                continue;
            }    
            if(major == nums[i]){
                count ++;
                continue;
            }
            if(major != nums[i] && count > 0){
                count --;
                continue;
            }
            if(major != nums[i] && count <= 0){
                major= nums[i];
                count ++;
                continue;
            }   
        }
        return major;
    }
}