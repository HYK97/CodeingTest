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
 * fileName : No18_DFS
 * author :  ddh96
 * date : 2022-12-16
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-16                ddh96             최초 생성
 */
public class No20_DFS {
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int m = Integer.parseInt(split[1]);
        int r = Integer.parseInt(split[2]);
        int[] visited = new int[n + 1];
        int[] visited2 = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            visited[i] = -1;
        }
        for (int i = 0; i < m; i++) {
            String[] split1 = br.readLine().split(" ");
            graph.get(Integer.parseInt(split1[0])).add(Integer.valueOf(split1[1]));
            graph.get(Integer.parseInt(split1[1])).add(Integer.valueOf(split1[0]));
        }
        for (List<Integer> integers : graph) {
            Collections.sort(integers);
        }
        dfs(visited, visited2, graph, r, 0);

        long result = 0;
        for (int i = 1; i < visited.length; i++) {
            result += ((long)visited[i] * visited2[i]);
        }
        bw.write(result + "\n");
        bw.flush();
    }

    public static void dfs(int[] visited, int[] visited2, List<List<Integer>> graph, int r, int depth) {
        visited[r] = depth;
        visited2[r] = count;
        for (Integer line : graph.get(r)) {
            if (visited[line] == -1) {
                count++;
                dfs(visited, visited2, graph, line, ++depth);
                depth--;
            }
        }
    }
}
