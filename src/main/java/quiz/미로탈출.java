package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {
    static int[][] data;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);
        data = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(split[j]);
            }
        }
        System.out.println(bfs(0, 0));
    }

    public static int bfs(int i, int j) {
        Queue<Node> que = new LinkedList<>();
        int[] dx = new int[]{-1, 1, 0, 0};
        int[] dy = new int[]{0, 0, -1, 1};
        que.add(new Node(i, j));
        while (!que.isEmpty()) {
            Node poll = que.poll();
            //조건
            for (int k = 0; k < 4; k++) {
                int x = poll.getX();
                int nx = x - dx[k];
                int y = poll.getY();
                int ny = y - dy[k];
                //맵밖으로 벗어났을때
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }
                //괴물을 만났을때
                if (data[nx][ny] == 0) {
                    continue;
                }
                //1일때 -> 갈수있는 길일때만
                // 상하좌우움직여서 안간노드는 que에 넣기
                if (data[nx][ny] == 1) {
                    data[nx][ny] = data[x][y] + 1;
                    que.offer(new Node(nx, ny));
                }
            }
        }
        //해당위치
        //도착지점이 따로 정해져있다면 ex 3,4 까지 최단거리 data[3][4]로 꺼내면됌
        //3 0 5 0 7 0
        //2 3 4 5 6 7
        //0 0 0 0 0 8
        //14 13 12 11 10 9
        //15 14 13 12 11 10
        //각거리의 최단거리 구해줌
        for (int[] datum : data) {
            for (int i1 : datum) {
                System.out.print(i1 + " ");
            }
            System.out.println();
        }
        return data[N - 1][M - 1];
    }

    static class Node {
        private int x;
        private int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }
}
