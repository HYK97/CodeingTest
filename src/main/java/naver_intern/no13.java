package naver_intern;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName :  naver_intern
 * fileName : no13
 * author :  ddh96
 * date : 2022-12-15 
 * description :https://www.acmicpc.net/problem/24479
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-15                ddh96             최초 생성
 */
public class no13 {
    static int[] rank;
    static List<List<Integer>> graph = new ArrayList<>();
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int r = Integer.parseInt(split[2]);
        rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            String[] data = br.readLine().split(" ");
            graph.get(Integer.parseInt(data[0])).add(Integer.valueOf(data[1]));
            graph.get(Integer.parseInt(data[1])).add(Integer.valueOf(data[0]));
        }
        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }
        dfs(r);

        for (int i = 1; i < rank.length; i++) {
            bw.write(rank[i] + "\n");
        }
        bw.flush();
    }

    public static void dfs(int start) {
        rank[start] = count;
        for (Integer i : graph.get(start)) {
            if (rank[i] == 0) {
                count += 1;
                dfs(i);
            }
        }

    }
}
