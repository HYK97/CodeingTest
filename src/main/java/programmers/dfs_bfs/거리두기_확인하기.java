package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName :  programmers.dfs_bfs
 * fileName : 거리두기_확인하기
 * author :  ddh96
 * date : 2023-04-12 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-12                ddh96             최초 생성
 */
public class 거리두기_확인하기 {

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        거리두기_확인하기 a = new 거리두기_확인하기();
        a.solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    }

    public int[] solution(String[][] places) {
        int[] answer = {};
        answer = new int[places.length];
        String[][][] map = new String[places.length][5][5];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            for (int j = 0; j < place.length; j++) {
                String value = place[j];
                String[] split = value.split("");
                for (int k = 0; k < split.length; k++) {
                    String s = split[k];
                    map[i][j][k] = s;
                }
            }

        }
        for (int i = 0; i < map.length; i++) {
            boolean bfs = bfs(map[i], 0, 0);
            answer[i] = bfs ? 1 : 0;
        }

        return answer;
    }

    public boolean bfs(String[][] map, int x, int y) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j].equals("P")) {
                    boolean[][] check = new boolean[5][5];
                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j, 0));
                    check[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point poll = queue.poll();
                        if (poll.count > 2) { //거리가 2이상인 경우
                            continue;
                        }
                        if (poll.count != 0 && map[poll.x][poll.y].equals(
                            "P")) { //자기자신 제외 p 인 경우 ->P를 한번이라도 마주치면 이어진 그래프로 판단해서 false
                            return false;
                        }
                        for (int k = 0; k < 4; k++) { //4방향 탐색
                            int nx = poll.x + dx[k];
                            int ny = poll.y + dy[k];
                            if (nx < 0 || nx > 4 || ny < 0 || ny > 4) {
                                continue;
                            }
                            if (check[nx][ny]) { //탐색한경우제외
                                continue;
                            }
                            if (map[nx][ny].equals("X")) { // x인경우는 제외
                                continue;
                            }
                            //O 인경우와 P 인경우에만 노드를 추가해서 탐색 -> 가다가 P를 한번이라도 마주치면 이어진 그래프로 판단해서 false
                            check[nx][ny] = true;
                            queue.add(new Point(nx, ny, poll.count + 1));

                        }
                    }
                }
            }
        }
        return true;
    }

    static class Point {
        int x;
        int y;
        int count;

        public Point(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;

        }
    }

}
