package algorithm.grapsearch;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS2 {
    static int N = 9;
    static Queue<Integer> que = new LinkedList<>();
    static boolean[] check = new boolean[N];
    static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        graph.get(1).add(2);
        graph.get(1).add(3);
        graph.get(1).add(8);

        graph.get(2).add(1);
        graph.get(2).add(7);

        graph.get(3).add(1);
        graph.get(3).add(4);
        graph.get(3).add(5);

        graph.get(4).add(3);
        graph.get(4).add(5);

        graph.get(5).add(3);
        graph.get(4).add(4);

        graph.get(6).add(7);

        graph.get(7).add(2);
        graph.get(7).add(6);
        graph.get(7).add(8);

        graph.get(8).add(1);
        graph.get(8).add(7);

        bfs(1);
    }

    private static void bfs(int i) {
        //첫번째 queue 값 셋팅
        check[i] = true;
        que.add(i);

        while (!que.isEmpty()) {
            // 큐 첫번째 방문한 노드 꺼내기
            Integer integer = que.poll();
            //꺼낸후에 출력
            System.out.print(integer + " ");
            //현재 노드에 연결된 것들중 방문하지않은 데이터들 queue에 추가 하고 방문 체크함
            for (int j = 0; j < graph.get(i).size(); j++) {
                int y = graph.get(i).get(j);
                if (!check[y]) {
                    check[y] = true;
                    que.offer(y);
                }
            }
            i++;
        }

    }
}