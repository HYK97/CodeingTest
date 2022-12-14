package naver_intern;

import java.util.Arrays;

/**
 * packageName :  naver_intern
 * fileName : no2
 * author :  ddh96
 * date : 2022-12-13 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42748
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-13                ddh96             최초 생성
 */
public class no2 {

    public static void main(String[] args) {
        int[] solution = solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}});
        System.out.println(Arrays.toString(solution));
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 1, newArray.length - 1);
        int count = 0;
        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] array2 = new int[j - i + 1];
            int index = 0;
            for (int l = i; l <= j; l++) {
                array2[index] = newArray[l];
                index++;
            }

            Arrays.sort(array2);
            answer[count] = array2[k - 1];
            count++;
        }
        return answer;

    }
}
