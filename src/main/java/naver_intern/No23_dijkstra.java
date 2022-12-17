package naver_intern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class No23_dijkstra {
    public static final int INF = Integer.MAX_VALUE;

    // 각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static List<List<Node>> graph = new ArrayList<>();
    // 최단 거리 테이블 만들기
    public static int[] d;

    public static void dijkstra(int start) {
        PriorityQueue<Node> que = new PriorityQueue<>();
        que.offer(new Node(start, 0));
        d[start] = 0;
        while (!que.isEmpty()) {

            Node node = que.poll();
            int dist = node.getDistance();
            int now = node.getIndex();

            if (d[now] < dist)
                continue;

            for (int i = 0; i < graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    que.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static int solution(int n, int[][] edge) {

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        d = new int[n + 1];
        for (int[] ints : edge) {
            graph.get(ints[0]).add(new Node(ints[1], 1));
            graph.get(ints[1]).add(new Node(ints[0], 1));
        }
        Arrays.fill(d, INF);
        dijkstra(1);
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            if (d[i] > max) {
                max = d[i];
            }
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (d[i] == max) {
                count++;
            }
        }

        return count;

    }

    static class Node implements Comparable<Node> {

        private int index;

        private int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }

        public int getIndex() {
            return this.index;
        }

        public int getDistance() {
            return this.distance;
        }

        @Override
        public int compareTo(Node other) {
            return this.distance - other.distance;
        }

        @Override
        public String toString() {
            return "Node{" +
                "index=" + index +
                ", distance=" + distance +
                '}';
        }
    }

}
