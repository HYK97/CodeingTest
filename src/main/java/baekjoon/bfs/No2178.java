package baekjoon.bfs;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class No2178 {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[1]);
        int[][] board = new int[x][y];
        boolean[][] check = new boolean[x][y];
        int[][] dist = new int[x][y];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
        for (int i = 0; i < x; i++) {
            int[] array = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            board[i] = array;
            Arrays.fill(check[i], false);
            Arrays.fill(dist[i], 0);
        }
        LinkedList<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        check[0][0] = true;
        dist[0][0]++;
        while (!queue.isEmpty()) {
            Pair current = queue.pollFirst();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
                    continue;
                }
                if (board[newX][newY] == 0 || check[newX][newY]) {
                    continue;
                }
                queue.add(new Pair(newX, newY));
                check[newX][newY] = true;
                dist[newX][newY] = dist[current.x][current.y] + 1;
            }
        }
        System.out.println(dist[x - 1][y - 1]);
    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
