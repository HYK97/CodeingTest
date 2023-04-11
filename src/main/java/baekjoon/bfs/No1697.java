package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * packageName : baekjoon.bfs
 * fileName : No1697
 * author : ddh96
 * date : 2023-04-11
 * description : https://www.acmicpc.net/problem/1697
 * ===========================================================
 * DATE AUTHOR NOTE
 * -----------------------------------------------------------
 * 2023-04-11 ddh96 최초 생성
 */
public class No1697 {

    private static final int MAX_POSITION = 100000;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int start = scan.nextInt();
        int end = scan.nextInt();
        if (start == end) {
            System.out.println(0);
            return;
        }
        boolean[] visited = new boolean[MAX_POSITION + 1];
        visited[start] = true;
        System.out.println(bfs(start, end, visited));
    }

    private static int bfs(int start, int end, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int count = 0;

        while (!queue.isEmpty()) {
            count++;
            int size = queue.size(); // inline   for (int i = 0; i < queue.size(); i++) { 실행시에 queue.size() 값이 변하기 때문에 size 변수에 담아서 고정해줌
            for (int i = 0; i < size; i++) {
                int currentPosition = queue.poll();
                if (currentPosition == end) {
                    return count - 1;
                }
                move(queue, visited, currentPosition - 1);
                move(queue, visited, currentPosition + 1);
                move(queue, visited, currentPosition * 2);
            }
        }
        return -1;
    }

    private static void move(Queue<Integer> queue, boolean[] visited, int position) {
        if (position >= 0 && position <= MAX_POSITION
            && !visited[position]) { // position이 0보다 작거나 MAX_POSITION 보다 크면 visited 배열의 index 범위를 벗어나기 때문에 제외 또 visited[position]이 true이면 이미 방문한 곳이기 때문에 제외
            visited[position] = true;
            queue.add(position);
        }
    }

}
