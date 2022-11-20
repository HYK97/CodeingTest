package quiz;

/**
 * packageName :  quiz
 * fileName : 만들수없는금액
 * author :  ddh96
 * date : 2022-11-20
 * description : 기초 그리디 문제
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-20                ddh96             최초 생성
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 동네 편의점의 주인인 동빈이는 N개의 동전을 가지고있습니다. 이때 N개의 동전을 이용하여 만들수 없는 양의 정수 금액 중 최솟값을 구하는 프로그램을 작성하세요.
 * <p>
 * ex) N = 5 이고 각 동전이 각각 3원 2원 1원 1원 9원 짜리 동전이라고 가정한다. 이때 동빈이가 만들수없는 정수금액중 최솟값은 8원입니다.
 * ex) N = 3 또다른 예시로 각각의 동적이 3원 5원 7원 동전이라고 가정할때 만들수없는 양의 정수금액중 최솟값은 1원이다.
 * 첫째 줄에는 동전의 개수를 나타내는 양의 정수 N이 주어진다 1<=N <=1000
 * 둘째 줄에는 각 동전의 화폐단위를 나타내는 N개의 자연수가 주어지며 각 자연수는 공백으로 구분한다. 이때 화폐의 단위는 1,000,000 이하의 자연수 입니다.
 * 첫째 줄에 주어진 동전들로 만들수 없는 양의 정수금액중 최솟값을 출력한다.
 * <p>
 * 입력 예시
 * 5
 * 3 2 1 1 9
 * <p>
 * 출력 예시
 * 8
 */
public class 만들수없는금액 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] data = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(data);

        int result = 1;
        for (int i = 0; i < N; i++) { // 0  ~  N 까지 하나씩 더해가면서 result를 늘린다.
            if (result < data[i]) {
                break;
            }
            result += data[i];
        }

        //            result  data[i]
        //i = 0          1   <   1    false
        //i = 1          2   <   1    false
        //i = 2          3   <   2    false
        //i = 3          5   <   3    false
        //i = 4          8   <   9    true

        System.out.println("result = " + result);
    }

}
