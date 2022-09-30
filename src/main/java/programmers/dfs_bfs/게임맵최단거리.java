package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {


    public static void main(String[] args) {
        게임맵최단거리 a = new 게임맵최단거리();
        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1},
                {0, 0, 1, 0, 0},
                {0, 0, 1, 1, 1}};
        int bfs = a.BFS(0, 0, maps);
        System.out.println("bfs = " + bfs);
        for (int[] s : maps) {
            for (int i : s) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public int BFS(int x, int y, int[][] maps) {
        Queue<Node> que = new LinkedList<>();
        int xlen = maps.length;
        int ylen = maps[0].length;

        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        que.add(new Node(x, y));
        while (!que.isEmpty()) {
            Node node = que.poll();
            for (int i = 0; i < 4; i++) {
                int xx = dx[i] + node.x;
                int yy = dy[i] + node.y;
                if (xx < 0 || yy < 0 || xx >= xlen || yy >= ylen || maps[xx][yy] == 0) {
                    continue;
                }
                if (maps[xx][yy] == 1) {
                    que.add(new Node(xx, yy));
                    maps[xx][yy] += maps[node.x][node.y];
                }
            }
        }
        if (maps[xlen - 1][ylen - 1] == 1) {
            return -1;
        }
        return maps[xlen - 1][ylen - 1];
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
