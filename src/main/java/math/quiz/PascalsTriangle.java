package math.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  math.quiz
 * fileName : PascalsTriangle
 * author :  ddh96
 * date : 2022-12-03
 * description : 파스칼 삼각형
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-03                ddh96             최초 생성
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> solution = solution(5);
        System.out.println(solution);
    }

    static List<List<Integer>> solution(int a) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < a; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                if (j == 0 || j == i) {
                    list.add(1);
                } else {
                    //좌측
                    int x = result.get(i - 1).get(j - 1);
                    //우측
                    int y = result.get(i - 1).get(j);
                    list.add(x + y);
                }
            }
            result.add(list);
        }

        return result;
    }

}
