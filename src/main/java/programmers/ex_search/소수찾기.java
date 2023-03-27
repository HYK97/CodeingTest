package programmers.ex_search;

import java.util.Arrays;
import java.util.HashSet;

/**
 * packageName :  programmers.ex_search
 * fileName : 소수찾기
 * author :  ddh96
 * date : 2023-03-28 
 * description :
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42839
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class 소수찾기 {

    static boolean[] visited;
    static int counts = 0;
    static HashSet<Integer> map = new HashSet<>();

    public static boolean isPrime(int n) {
        // 2 미만의 수는 소수가 아님
        if (n < 2) {
            return false;
        }
        // 2는 유일한 짝수 소수
        if (n == 2) {
            return true;
        }
        // 짝수는 소수가 아님
        if (n % 2 == 0) {
            return false;
        }
        // 제곱근까지만 홀수로 나누어보기
        int sqrt = (int)Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        // 나누어 떨어지는 수가 없으면 소수
        return true;
    }

    public void permutation(int[] arr, int depth, int n, int r, String data) {
        if (depth == r) {
            map.add(Integer.parseInt(data));
            //System.out.println("Integer.parseInt(data) = " + Integer.parseInt(data));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                permutation(arr, depth + 1, n, r, data + arr[i]);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        int answer = 0;
        int[] number = Arrays.stream(numbers.split("")).mapToInt(Integer::parseInt).toArray();
        visited = new boolean[number.length];
        for (int i = 1; i < 8; i++) {
            permutation(number, 0, numbers.length(), i, "");
        }
        for (Integer integer : map) {
            if (isPrime(integer)) {
                counts++;
            }
        }
        return counts;
    }
}
