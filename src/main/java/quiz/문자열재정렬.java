package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  quiz
 * fileName : 문자열재정렬
 * author :  ddh96
 * date : 2022-11-25
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-25                ddh96             최초 생성
 */
public class 문자열재정렬 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        String[] split = data.split("");
        Arrays.sort(split);

        int sum = 0;
        int checkString = 0;
        for (int i = 0; i < split.length; i++) {
            if (split[i].chars().allMatch(Character::isDigit)) {
                sum += Integer.parseInt(split[i]);
            } else {
                checkString = i;
                break;
            }
        }

        System.out.println(String.join("", split).substring(checkString) + sum);


    }
}
