package math.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  math.quiz
 * fileName : PermutationQuiz2
 * author :  ddh96
 * date : 2022-12-05 
 * description : 문자 열 s1 와 s2 가 주어졌을때 , s1 을 permutation 한 문자 열이   s2 의 부분
 * 문자열에 해당하면 true 를 반환 하고 그렇지 않으면 false 를 반환하는 프로그램 작성
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-05                ddh96             최초 생성
 */
public class PermutationQuiz2 {

    public static void main(String[] args) {
        solution1("ab", "aabbkk");
    }

    static void solution1(String s1, String s2) {
        String[] split = s1.split("");
        List<String> list = new ArrayList<>();
        permutation(split, 0, new boolean[split.length], new String[split.length], list);
        boolean flag = false;
        for (String s : list) {
            if (s2.contains(s)) {
                flag = true;
                System.out.println(true);
                break;
            }
        }
        if (!flag) {
            System.out.println(false);
        }
    }

    static void permutation(String[] arr, int depth, boolean[] visited, String[] out, List<String> list) {
        int length = arr.length;
        if (depth == length) {
            list.add(String.join("", out));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                out[depth] = arr[i];
                permutation(arr, depth + 1, visited, out, list);
                visited[i] = false;
            }
        }
    }

}
