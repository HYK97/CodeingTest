package programmers.ex_search;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * packageName :  programmers.ex_search
 * fileName : 전력망둘로나누기
 * author :  ddh96
 * date : 2022-12-08 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-08                ddh96             최초 생성
 */
public class 전력망둘로나누기 {

    static int counts;

    public static void dfs(List<List<Integer>> graph, int start, boolean check[]) {
        List<Integer> integers = graph.get(start);
        counts++;
        check[start] = true;
        for (Integer integer : integers) {
            if (!check[integer]) {
                dfs(graph, integer, check);
            }
        }
        check[start] = false;
    }

    public static void main(String[] args) {
        solution(5, new int[][] {{1, 2}, {2, 3}, {3, 4}, {4, 5}});
    }

    public static int solution(int n, int[][] wires) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] wire : wires) {
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        List<Integer> result = new ArrayList<>();
        for (int[] wire : wires) {
            graph.get(wire[0]).remove(Integer.valueOf(wire[1]));
            graph.get(wire[1]).remove(Integer.valueOf(wire[0]));
            counts = 0;
            dfs(graph, wire[0], new boolean[n + 1]);
            int e = n - counts - counts;
            result.add(Math.abs(e));
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }

        return result.stream().min(Comparator.comparing(i -> i)).get();
    }

}
