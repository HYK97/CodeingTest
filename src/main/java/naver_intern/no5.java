package naver_intern;

import java.util.LinkedList;
import java.util.Queue;

/**
 * packageName :  naver_intern
 * fileName : no5
 * author :  ddh96
 * date : 2022-12-14 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/1844
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-14                ddh96             최초 생성
 */
public class no5 {
    public static void main(String[] args) {
        int[][] solution1 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}};
        int[][] solution2 = {{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 0}, {0, 0, 0, 0, 1}};
        int solution = solution(solution1);
        int solution3 = solution(solution2);
        System.out.println(solution);
        System.out.println(solution3);
    }

    public static int solution(int[][] maps) {
        Queue<Node> queue = new LinkedList<>();
        int limitX = maps.length;
        int limitY = maps[0].length;
        int dx[] = new int[] {-1, 1, 0, 0};
        int dy[] = new int[] {0, 0, -1, 1};

        queue.add(new Node(0, 0));
        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            // 동서남북 확인후 1인경우 queue에 넣기
            for (int i = 0; i < 4; i++) {
                int moveX = dx[i] + currentNode.x;
                int moveY = dy[i] + currentNode.y;

                if (moveX < 0 || moveY < 0 || moveX >= limitX || moveY >= limitY) {
                    continue;
                }
                if (maps[moveX][moveY] == 1) {
                    queue.add(new Node(moveX, moveY));
                    //지나온값의 최솟값
                    maps[moveX][moveY] += maps[currentNode.x][currentNode.y];
                }
            }
        }
        if (maps[limitX - 1][limitY - 1] == 1) {
            return -1;
        }
        return maps[limitX - 1][limitY - 1];
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
