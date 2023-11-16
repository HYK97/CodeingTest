package leetcode.learn;
/*
* https://leetcode.com/problems/richest-customer-wealth/
* */
public class No1672 {
    public int maximumWealth(int[][] accounts) {
        int max = -1;
        for (int[] account : accounts) {
            int sumData=0;
            for (int i : account) {
                sumData+=i;
            }
            max=Integer.max(sumData,max);
        }
        return max;
    }
}
