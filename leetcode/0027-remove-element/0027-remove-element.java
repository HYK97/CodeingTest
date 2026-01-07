class Solution {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int count = 0;

        if (nums.length == 1 && val == nums[0]){
            return 0;
        } else if(nums.length == 1 && val != nums[0]) {
            return 1;
        }

        while (left <= right) {
            int target = nums[left];
            if(target != val){
                count++;
                left++;
                continue;
            }
            while(val == nums[right] && left < right){
                right--;
            }
            if(left >= right){
                break;
            }
            int temp = nums[right];
            nums[left]= temp;
            nums[right]= target;
            count++;
            left++;

        }
        
        for(int num : nums){
            System.out.println("array : " + num);
        }

        System.out.println("test : " + count);
        return count;
    }
    
}