package leetcode.learn;
/*
*https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero
* */
public class No1342 {
    public int numberOfSteps(int num) {
        int count =0;
        int initData = num;
        while (initData!=0) {
            if (initData % 2 == 0) {
                initData=initData/2;
            } else {
                initData=initData-1;
            }
            count++;
        }
        return count;
    }
}
