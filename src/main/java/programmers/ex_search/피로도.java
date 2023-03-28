package programmers.ex_search;

/**
 * packageName :  programmers.ex_search
 * fileName : 피로도
 * author :  ddh96
 * date : 2023-03-28 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-28                ddh96             최초 생성
 */
public class 피로도 {

    static boolean[] check;
    static int counts = 0;

    public static void main(String[] args) {
        int solution = solution(80, new int[][] {{80, 20}, {50, 40}, {30, 10}});
        System.out.println(solution);
    }

    public static int solution(int k, int[][] dungeons) {
        int answer = -1;
        check = new boolean[dungeons.length];
        dfs(k, dungeons, 0);
        return counts;
    }

    public static void dfs(int k, int[][] dungeons, int depth) {

        for (int i = 0; i < dungeons.length; i++) {
            if (!check[i] && dungeons[i][0] <= k) {
                check[i] = true;
                int 소모피로도 = dungeons[i][1];
                dfs(k - 소모피로도, dungeons, depth + 1);
                check[i] = false;
            }
        }
        counts = Math.max(counts, depth);
    }
}
