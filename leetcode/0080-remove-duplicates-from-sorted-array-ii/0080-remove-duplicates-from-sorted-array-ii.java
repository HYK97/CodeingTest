class Solution {
    // 중복은 최대 2개 이상은 되면 안된다.
    public int removeDuplicates(int[] nums) {
        int target = 0 ; // 변경할 위치의 인덱스 
        for(int search = 0 ;/** search 한칸씩 움직이며 원소를 찾을 인덱스 */ search <  nums.length ; search++){
            if (search < 2){
                target++;
                continue;
            }
            int targetNum = nums[target-2];
            int searchNum = nums[search];
            if (targetNum != searchNum){
                nums[target] = nums[search];
                target++;
            }                
        }
        return target;
    }
}