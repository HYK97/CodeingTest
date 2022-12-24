package programmers.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * packageName :  programmers.dijkstra
 * fileName : 배달
 * author :  ddh96
 * date : 2022-12-23 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-23                ddh96             최초 생성
 */
public class 배달 {

    static int[] table;
    static List<List<Node>> graph = new ArrayList<>();

    public static void main(String[] args) {
        int solution = solution(5, new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}}, 3);
        System.out.println(solution);
    }

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        // n 노드개수 1 ~ N 까지
        table = new int[N + 1];
        Arrays.fill(table, Integer.MAX_VALUE);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }
        dijkstra();
        for (int j : table)
            if (j <= K) {
                answer++;
            }
        return answer;
    }

    public static void dijkstra() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        table[1] = 0;
        que.offer(new Node(1, 0));
        while (!que.isEmpty()) {
            Node poll = que.poll();
            int currentIndex = poll.index;
            for (Node linkedNode : graph.get(currentIndex)) {
                int nextIndex = linkedNode.index;
                int nextCost = table[currentIndex] + linkedNode.cost;
                if (table[nextIndex] > nextCost) {
                    table[nextIndex] = nextCost;
                    que.offer(linkedNode);
                }
            }
        }
    }

    static class Node implements Comparable<Node> {
        int index;
        int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            return this.cost - node.cost;
        }
    }
}
