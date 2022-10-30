package programmers.dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;

public class 여행경로 {
    boolean[] visited;
    ArrayList<String> table = new ArrayList<>();

    public String[] solution(String[][] tickets) {
        String[] answer;
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        Collections.sort(table);
        answer = table.get(0).split(" ");
        return answer;
    }

    public void dfs(String now, String path, String[][] tickets, int count) {
        if (count == tickets.length) {
            table.add(now);
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (path.equals(tickets[i][0]) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], now + " " + tickets[i][1], tickets, count + 1);
                visited[i] = false;
            }
        }
    }
}
