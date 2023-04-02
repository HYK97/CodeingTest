package programmers.dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName :  programmers.dfs_bfs
 * fileName : 아이템_줍기
 * author :  ddh96
 * date : 2 23- 4- 1 
 * description :https://school.programmers.co.kr/learn/courses/3 /lessons/87694
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2 23- 4- 1                ddh96             최초 생성
 */
public class 아이템_줍기 {
    public static int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        characterX = characterX * 2;
        characterY = characterY * 2;
        itemX = itemX * 2;
        itemY = itemY * 2;

        int[][] map = new int[16][16];

        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};

        for (int[] ints : rectangle) {
            int x1 = 2 * ints[0];
            int x2 = 2 * ints[2];
            int y1 = 2 * ints[1];
            int y2 = 2 * ints[3];

            for (int i = 0; i <= x2 - x1; i++) {
                int target = x1 + i;
                // 해당 칸이 0일 경우에만 1로 바꾸어줌
                if (map[y1][target] == 0) {
                    map[y1][target] = 1;
                }

                if (map[y2][target] == 0) {
                    map[y2][target] = 1;
                }
                // 테두리 부분을 피해서 안쪽 부분만 채워줌
                if (target != x1 && target != x2) {
                    // 그 안쪽은 2로 채워줌, 만약 너비가 2초과일 경우에만 해당
                    for (int j = y1 + 1; j < y2; j++) {
                        map[j][target] = 2;
                    }
                }
            }
            // y 축 채우기
            for (int i = 0; i < y2 - y1; i++) {
                int target = y1 + i;
                // 해당 칸이 0일 경우에만 1로 바꾸어줌
                if (map[target][x1] == 0) {
                    map[target][x1] = 1;
                }
                if (map[target][x2] == 0) {
                    map[target][x2] = 1;
                }

            }
        }

        map[characterY][characterX] = 1;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(characterX, characterY));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx <= 100 && nx >= 1 && ny <= 100 && ny >= 1 && map[ny][nx] == 1) {
                    map[ny][nx] = map[node.y][node.x] + 1;
                    queue.offer(new Node(nx, ny));
                    if (ny == itemY && nx == itemX) {
                        break;
                    }
                }
            }
        }
        return map[itemY][itemX] / 2;
    }

    public static void main(String[] args) {
        int solution = solution(new int[][] {{1, 1, 7, 4}, {3, 2, 5, 5}, {4, 3, 6, 9}, {2, 6, 8, 8}}, 1, 3, 7, 8);
        System.out.println("solution = " + solution);
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

/*
*
-1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 3 4 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 2 -1 6 7 8 -1 10 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 1 -1 5 6 7 8 9 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 2 3 4 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 -1 -1 5 6 7 8 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 -1 7 6 7 8 9 10 11 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 -1 8 -1 8 -1 10 -1 12 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 -1 9 10 9 10 11 12 13 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
-1 -1 -1 -1 10 11 12 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1 -1
*
* */