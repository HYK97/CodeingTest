package baekjoon.bfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/**
 * packageName :  baekjoon.bfs
 * fileName : No1260
 * author :  ddh96
 * date : 2023-04-03 
 * description : https://www.acmicpc.net/problem/1260
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-03                ddh96             최초 생성
 */
public class No1260 {
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited1;
    static boolean[] visited2;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int N = scan.nextInt();
        int M = scan.nextInt();
        int V = scan.nextInt();

        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }
        visited1 = new boolean[list.size()];
        visited2 = new boolean[list.size()];

        for (int i = 0; i < M; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            list.get(a).add(b);
            list.get(b).add(a);
        }

        dfs(V);
        System.out.println("");
        bfs(V);

    }

    public static void dfs(int start) {

        visited1[start] = true;
        System.out.print(start + " ");
        list.get(start).sort(Comparator.comparing(Integer::intValue));
        for (int i = 0; i < list.get(start).size(); i++) {
            Integer integer = list.get(start).get(i);
            if (!visited1[integer]) {
                visited1[integer] = true;
                dfs(integer);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            if (!visited2[poll]) {
                visited2[poll] = true;
                System.out.print(poll + " ");
                List<Integer> indexList = list.get(poll);
                indexList.sort(Comparator.comparing(Integer::intValue));
                for (Integer integer : indexList) {
                    queue.offer(integer);
                }
            }

        }
    }
}
