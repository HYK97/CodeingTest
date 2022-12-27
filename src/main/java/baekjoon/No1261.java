package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * packageName :  baekjoon
 * fileName : No1261
 * author :  ddh96
 * date : 2022-12-21 
 * description : https://www.acmicpc.net/problem/1261
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-21                ddh96             최초 생성
 */
public class No1261 {
    static int X;
    static int Y;
    static int[][] table;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        X = Integer.parseInt(split[0]);
        Y = Integer.parseInt(split[1]);

        int[][] map = new int[Y][X];
        table = new int[Y][X];
        for (int i = 0; i < Y; i++) {
            String[] input = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                map[i][j] = Integer.parseInt(input[j]);
                Arrays.fill(table[i], Integer.MAX_VALUE);
            }
        }
        simulation(0, 0, map);
        System.out.println(table[Y - 1][X - 1]);
    }

    private static void simulation(int x, int y, int[][] map) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int dx[] = new int[] {-1, 1, 0, 0};
        int dy[] = new int[] {0, 0, -1, 1};
        table[y][x] = 0;
        queue.add(new Node(x, y, 0));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            //인접노드 확인
            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + node.x;
                int nextY = dy[i] + node.y;
                int nextCost = node.cost; //현재 가중치

                //4방향 확인
                if (nextX < 0 || nextY < 0 || nextX >= X || nextY >= Y) {
                    continue;
                }

                //가중치를 미리세팅하는게 아니라서 그때 그때 세팅함
                if (map[nextY][nextX] == 1) {
                    nextCost++; //현재가중치에서 1추가
                }

                if (table[nextY][nextX] > nextCost) { //다음칸의 원래가중치 값과     현재경로로온 가중치를 비교
                    table[nextY][nextX] = nextCost; //더작은 경우 변경
                    queue.add(new Node(nextX, nextY, nextCost));
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }

}
