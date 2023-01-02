package programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * packageName :  programmers.dfs_bfs
 * fileName : 네트워크풀이2
 * author :  ddh96
 * date : 2023-01-02 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/43162
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-02                ddh96             최초 생성
 */
public class 네트워크풀이2 {
    int[] visited;
    List<List<Integer>> graph = new ArrayList<>();

    public int solution(int n, int[][] computers) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (i != j && computers[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        visited = new int[n];
        for (int i = 0; i < n; i++) {
            if (Arrays.stream(visited).anyMatch(j -> j == 0)) {
                if (visited[i] == 0) {
                    dfs(i);
                    answer++;
                }
            }
        }
        return answer;
    }

    private void dfs(Integer node) {
        if (visited[node] == 1) {
            return;
        }
        visited[node] = 1;
        for (int i = 0; i < graph.get(node).size(); i++) {
            dfs(graph.get(node).get(i));
        }
    }
}
