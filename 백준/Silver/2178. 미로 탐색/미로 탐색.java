
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName :  baekjoon.bfs
 * fileName : No2178
 * author :  ddh96
 * date : 2023-04-04 
 * description : https://www.acmicpc.net/problem/2178
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-04                ddh96             최초 생성
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int M = Integer.parseInt(s[1]);
        int[][] map = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(split[j - 1]);
            }
        }
        int dx[] = new int[] {-1, 1, 0, 0};
        int dy[] = new int[] {0, 0, -1, 1};
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(1, 1));
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nextX = poll.x + dx[i];
                int nextY = poll.y + dy[i];
                if (nextX < 1 || nextY < 1 || nextX > M || nextY > N || map[nextY][nextX] == 0) {
                    continue;
                }
                if (map[nextY][nextX] == 1) {
                    map[nextY][nextX] = map[poll.y][poll.x] + 1;
                    queue.add(new Node(nextX, nextY));
                }
            }

        }

        System.out.println(map[N][M]);

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
