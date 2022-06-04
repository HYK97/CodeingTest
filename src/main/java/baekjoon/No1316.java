package baekjoon;

import java.util.Scanner;

public class No1316 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int result = 0;
        for (int i = 0; i < input; i++) {
            String string = sc.next();
            boolean check = isCheck(string);
            if (check) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static boolean isCheck(String string) {
        boolean checkArr[] = new boolean[26];
        boolean check = true;
        //두번째 문자 부터 비교
        for (int j = 0; j < string.length(); j++) {
            int now = string.charAt(j) - 'a'; // 97~112 아스키코드 -97
            if (checkArr[now] == true) { //해당 문자 사용한 적 있음
                if (string.charAt(j - 1) - 'a' != now) { //이전 값과 같은지 다르면 그룹단어가아님
                    check = false;
                }
            } else { //해당 문자 사용한 적 없음.
                checkArr[now] = true;
            }
        }
        return check;
    }
}