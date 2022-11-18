package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  quiz
 * fileName : 곱하기혹은더하기
 * author :  ddh96
 * date : 2022-11-18
 * description : 곱하기 혹은 더하기
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-18                ddh96             최초 생성
 */
public class 곱하기혹은더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(array);
        int result = 0;
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] <= 1 || result <= 1) { // 더할값이 1보다 작거나 또는 현재 계산값이 1보다 작거나 같을때는 더해주고
                result += array[i];
            } else { //그게 아니라면 모든값들은 곱해준다.
                result *= array[i];
            }
        }
        System.out.println("result = " + result);
    }

}
