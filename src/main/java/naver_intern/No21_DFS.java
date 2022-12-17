package naver_intern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName :  naver_intern
 * fileName : No21_DFS
 * author :  ddh96
 * date : 2022-12-16 
 * description :
 * 1.벽치고
 * 2.바이러스 퍼뜨리고
 * 3.스코어 구하고
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-16                ddh96             최초 생성
 */
public class No21_DFS {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int WALL = 1;
    static int VIRUS = 2;
    static int EMPTY = 0;
    static int max = Integer.MIN_VALUE;
    static int[][] backupGraph;
    static int[][] graph;
    static int N;//세로
    static int M;//가로

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        N = Integer.parseInt(split[0]);//세로
        M = Integer.parseInt(split[1]);//가로
        graph = new int[N][M];
        backupGraph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] split1 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(split1[j]);
            }
        }

        dfs(0);
        System.out.println(max);

    }

    private static void dfs(int wallCount) {
        if (wallCount == 3) {
            //한번시뮬레션할떄마다 그래프 초기화
            copyMap();
            //시뮬레이터
            simulator();
            //전체 카운트 구하기
            max = Math.max(max, getResult());
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == EMPTY) {
                    graph[i][j] = WALL;
                    wallCount++;
                    dfs(wallCount);
                    graph[i][j] = EMPTY;
                    wallCount--;
                }
            }
        }

    }

    private static void copyMap() {
        for (int i = 0; i < N; i++) {
            System.arraycopy(graph[i], 0, backupGraph[i], 0, graph[i].length);
        }
    }

    private static void simulator() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (backupGraph[i][j] == VIRUS) {
                    simulation(i, j);
                }
            }
        }
    }

    private static void simulation(int i, int j) {
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if (backupGraph[nx][ny] == EMPTY) {
                    backupGraph[nx][ny] = VIRUS;
                    simulation(nx, ny);
                }
            }
        }
    }

    private static int getResult() {
        int count = 0;
        for (int[] ints : backupGraph) {
            for (int index : ints) {
                if (index == 0) {
                    count++;
                }
            }
        }
        return count;
    }

}
