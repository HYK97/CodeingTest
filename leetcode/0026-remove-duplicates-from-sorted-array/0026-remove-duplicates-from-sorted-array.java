// 포인터 2개로 풀어보자

class Solution {
    public int removeDuplicates(int[] nums) {
        // 타켓 포인터와
        // 포인터를 움직이면서 다음 번호를 찾아내고 그 타켓 포인터의 자리에 놓으면됌
        int target = 0;
        for(int search=0 ; search < nums.length; search++){
            int searchNum = nums[search];
            int targetNum = nums[target];
            if(searchNum == targetNum){
                continue;
            }
            target++;
            nums[target]=nums[search];
        }
        return target+1;
    }
}