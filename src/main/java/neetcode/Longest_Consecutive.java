package neetcode;

import java.util.HashSet;
/*
* https://neetcode.io/problems/longest-consecutive-sequence
* */
class Longest_Consecutive {

    public static void main(String[] args) {
        Longest_Consecutive solution = new Longest_Consecutive();
        int i = solution.longestConsecutive(new int[]{2, 20, 4, 10, 3, 4, 5});
        System.out.println("i = " + i);
    }

    /*
    * n-1이 있는지 계속 순회하면서 연속하는 수의 최대 개수 구하기
    * */
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 0;
        int count = 0;
        for (int num : nums) {
            while (set.contains(num - 1)) {
                count++;
                num--;
            }
            if (set.contains(num)) {
                count++;
            }
            max = Math.max(count, max);
            count = 0;
        }
        return max;
    }
}
