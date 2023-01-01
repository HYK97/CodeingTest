package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * packageName :  baekjoon.bfs
 * fileName : No7569
 * author :  ddh96
 * date : 2022-12-29 
 * description :https://www.acmicpc.net/problem/7569
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-29                ddh96             최초 생성
 */
public class No7569 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] dz = {0, 0, 0, 0, -1, 1};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dx = {-1, 1, 0, 0, 0, 0};

        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        int[][][] tomato = new int[h][n][m];
        Queue<Point> ripeTomatoes = new LinkedList<>();
        int unripeTomatoes = 0, days = 0;

        for (int i = 0; i < h; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < m; k++) {
                    tomato[i][j][k] = sc.nextInt();
                    if (tomato[i][j][k] == 0)
                        unripeTomatoes++;
                    else if (tomato[i][j][k] == 1)
                        ripeTomatoes.add(new Point(i, j, k));
                }
        while (unripeTomatoes > 0 && !ripeTomatoes.isEmpty()) {
            int size = ripeTomatoes.size();
            for (int i = 0; i < size; i++) {
                Point l = ripeTomatoes.remove();
                int z = l.z;
                int y = l.y;
                int x = l.x;

                for (int j = 0; j < 6; j++) {
                    int nz = z + dz[j];
                    int ny = y + dy[j];
                    int nx = x + dx[j];

                    if (nz < 0 || ny < 0 || nx < 0 || nz >= h || ny >= n || nx >= m)
                        continue;
                    else if (tomato[nz][ny][nx] != 0)
                        continue;

                    unripeTomatoes--;
                    tomato[nz][ny][nx] = 1;
                    ripeTomatoes.add(new Point(nz, ny, nx));
                }
            }
            days++;
        }
        System.out.println(unripeTomatoes == 0 ? days : -1);
    }

    static class Point {
        int z;
        int y;
        int x;

        Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

}
