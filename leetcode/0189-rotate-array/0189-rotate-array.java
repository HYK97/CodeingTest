class Solution {
    //nums 만큼 회전하면 원래대로 돌아오기 때문에 nums.length 보다 k가 작다면 그냥 하나씩 옮기면되고
    //만약 크다면 nums.length / k 만큼만 움직이면 됌
    public void rotate(int[] nums, int k) {
        if (nums.length == k){
            return;
        }
        int index = k % nums.length;
        swap(nums,0,nums.length-1);
        swap(nums,0,index-1);
        swap(nums,index,nums.length-1);
    }
    
    public void swap(int [] nums , int p1, int p2){
        while(p1 < p2){
            int temp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = temp;
            p1++;
            p2--;
        }
    }
}