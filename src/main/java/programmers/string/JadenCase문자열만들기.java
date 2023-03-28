package programmers.string;

/**
 * packageName :  programmers.string
 * fileName : JadenCase문자열만들기
 * author :  ddh96
 * date : 2023-03-28 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/12951
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class JadenCase문자열만들기 {
    public static void main(String[] args) {
        String solution = solution("for      the    last   week  ");
        System.out.println("solution = " + solution + "1");
    }

    public static String solution(String s) {
        String[] data = s.split(" ", -1);

        for (int i = 0; i < data.length; i++) {
            String datum = data[i];
            char[] chars = datum.toCharArray();
            if (chars.length > 0 && ((chars[0] >= 'a' && chars[0] <= 'z') || (chars[0] >= 'A' && chars[0] <= 'Z'))) {
                String s1 = datum.toLowerCase();
                char[] chars1 = s1.toCharArray();
                chars1[0] = (char)(chars1[0] - 32);
                data[i] = new String(chars1);

            } else {
                data[i] = datum.toLowerCase();
            }
        }
        return String.join(" ", data);
    }
}
