package quiz;

import java.util.Arrays;

/**
 * packageName :  quiz
 * fileName : 나뭇가지구하기
 * author :  ddh96
 * date : 2023-01-12 
 * description : 나뭇가지구하기
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-12                ddh96             최초 생성
 */
public class 나뭇가지구하기 {
    public static void main(String[] args) {

        int solution = solution(12, new int[] {23, 2, 44, 23, 4, 2});
        System.out.println("solution = " + solution);
    }

    public static int solution(int N, int[] branches) {
        int min = 1;
        int answer = Integer.MIN_VALUE;
        Arrays.sort(branches);
        int max = Arrays.stream(branches).sum();
        while (min <= max) {
            int sum = 0;
            int mid = (min + max) / 2;
            for (int branch : branches) {
                if (mid <= branch) {
                    sum += branch / mid;
                }
            }

            if (sum > N) {
                min = mid + 1;
            } else if (sum < N) {
                max = mid - 1;
            } else {
                answer = mid;
                break;
            }
        }
        return answer == Integer.MIN_VALUE ? -1 : answer;
    }
}
