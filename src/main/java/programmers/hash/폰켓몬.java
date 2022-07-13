package programmers.hash;

import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {
    public static void main(String[] args) {
        solution(new int[]{1, 2, 3, 4});
    }

    public static int solution(int[] nums) {
        Set<Integer> choice = new HashSet<>();
        int answer = 0;
        int choiceNum = nums.length / 2;
        System.out.println(choiceNum);
        for (int num : nums) {
            choice.add(num);
        }
        if (choice.size() > choiceNum) {
            answer = choiceNum;
        } else {
            answer = choice.size();
        }
        return answer;
    }
}
