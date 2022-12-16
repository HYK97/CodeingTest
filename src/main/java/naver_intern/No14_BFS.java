package naver_intern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * packageName :  naver_intern
 * fileName : No14_BFS
 * author :  ddh96
 * date : 2022-12-16 
 * description :https://www.acmicpc.net/problem/24444
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-16                ddh96             최초 생성
 */
public class No14_BFS {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int r = Integer.parseInt(split[2]);
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] data = br.readLine().split(" ");
            graph.get(Integer.parseInt(data[0])).add(Integer.valueOf(data[1]));
            graph.get(Integer.parseInt(data[1])).add(Integer.valueOf(data[0]));
        }
        Integer[] visited = new Integer[n + 1];
        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }
        bfs(visited, graph, r);

        for (int i = 1; i < visited.length; i++) {
            Integer integer = visited[i];
            bw.write(integer != null ? integer + "\n" : "0\n");
        }
        bw.flush();

    }

    private static void bfs(Integer[] visited, List<List<Integer>> graph, int r) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(r);
        int count = 1;
        visited[r] = count;
        count++;
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer i : graph.get(poll)) {
                if (visited[i] == null) {
                    visited[i] = count;
                    count++;
                    queue.add(i);
                }
            }

        }

    }
}
