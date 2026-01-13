//현재 갈 수 있는 거리를 기억 하면서 간다 마치 배터리처럼
//현재 값 보다 배터리가 많은경우에는 교체
class Solution {
    public boolean canJump(int[] nums) {
        int maxValue = 0;
        for (int i = 0; i < nums.length ; i++){
            int num = nums[i];
            if (maxValue < num){
                maxValue = num - 1;
            } else if (maxValue == 0 && num == 0 && i != nums.length - 1) {
                return false;
            } else{
                maxValue--;
            }
        }
        return true;
    }
}