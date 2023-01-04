package programmers.ex_search;

/**
 * packageName :  programmers.ex_search
 * fileName : 카펫
 * author :  ddh96
 * date : 2023-01-04 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-04                ddh96             최초 생성
 */
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int a = 3; // 가로
        int b; // 세로
        for (int i = 1; i < 5000; i++) {
            b = 1;
            for (int j = 1; j < 5000; j++) {
                int brownLength = 2 * (a + b);
                int c = a - 2;
                int d = b;
                int yellowWidth = c * d;
                if (brownLength == brown && yellowWidth == yellow) {
                    answer = new int[] {b + 2, a};
                    return answer;
                }
                b++;
            }
            a++;
        }

        //사용하지않음
        return answer;
    }
}
