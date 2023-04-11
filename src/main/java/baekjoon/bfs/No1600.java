package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * packageName :  baekjoon.bfs
 * fileName : No1600
 * author :  ddh96
 * date : 2023-04-04
 * description :https://www.acmicpc.net/problem/1600
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-04                ddh96             최초 생성
 */

public class No1600 {

    static int k, w, h; // k: 말 움직임 가능 횟수, w: 가로 길이, h: 세로 길이
    static int[][] board; // 격자판 정보를 담을 배열
    static int min = Integer.MAX_VALUE; // 최소 동작수를 저장할 변수
    // 말의 움직임을 표현하는 x, y 방향 배열
    static int[] hdx = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] hdy = {-1, 1, -2, 2, -2, 2, -1, 1};
    // 원숭이의 움직임을 표현하는 x, y 방향 배열
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][][] visited; // 방문 여부를 저장할 배열

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        k = scan.nextInt(); // 말 움직임 가능 횟수 입력 받기
        w = scan.nextInt(); // 가로 길이 입력 받기
        h = scan.nextInt(); // 세로 길이 입력 받기

        board = new int[h][w]; // 격자판 배열 크기 할당
        // 격자판 정보 입력 받기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = scan.nextInt();
            }
        }

        visited = new boolean[h][w][k + 1]; // 방문 배열 크기 할당
        min = bfs(0, 0); // bfs 탐색 시작

        if (min == Integer.MAX_VALUE)
            System.out.println("-1"); // 도착할 수 없는 경우
        else
            System.out.println(min); // 최소 동작수 출력
    }

    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 0, k)); // 시작 위치와 횟수, 말 움직임 횟수를 큐에 삽입
        visited[x][y][k] = true; // 시작 위치를 방문 처리

        while (!q.isEmpty()) {
            Node current = q.poll(); // 현재 위치 정보를 가져옴
            // 현재 위치가 도착점인 경우 동작 수를 반환
            if (current.x == h - 1 && current.y == w - 1)
                return current.count;

            // 원숭이의 움직임에 대한 탐색
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                // 다음 위치가 범위 내이고, 방문하지 않았으며, 평지인 경우
                if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k] && board[nx][ny] == 0) {
                    visited[nx][ny][current.k] = true; // 방문 처리
                    q.offer(new Node(nx, ny, current.count + 1, current.k)); // 큐에 삽입
                }
            }

            // 현재 말의 움직임 횟수가 남아있는 경우
            if (current.k > 0) {
                // 말의 움직임에 대한 탐색
                for (int i = 0; i < 8; i++) {
                    int nx = current.x + hdx[i];
                    int ny = current.y + hdy[i];
                    // 다음 위치가 범위 내이고, 방문하지 않았으며, 평지인 경우
                    if (nx >= 0 && ny >= 0 && nx < h && ny < w && !visited[nx][ny][current.k - 1]
                        && board[nx][ny] == 0) {
                        visited[nx][ny][current.k - 1] = true; // 방문 처리
                        q.offer(new Node(nx, ny, current.count + 1, current.k - 1)); // 큐에 삽입
                    }
                }
            }
        }
        return min; // 최소 동작수를 반환
    }

    // 노드 클래스 정의 (위치 정보, 동작 수, 말의 움직임 횟수를 저장)
    public static class Node {
        int x;
        int y;
        int count;
        int k;

        public Node(int x, int y, int count, int k) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.k = k;
        }
    }
}
