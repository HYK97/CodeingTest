package programmers.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 가장먼노드 {

    /**
     * n은 노드수  edge > 간선 그래프
     */
    static List<List<Node>> list = new ArrayList<>();
    static int[] table = new int[20001];

    public static void main(String[] args) {
        int solution = solution(11, new int[][]{
                {3, 6},
                {4, 3},
                {3, 2},
                {1, 3},
                {1, 2},
                {2, 4},
                {5, 2},
                {7, 4},
                {7, 5},
                {8, 9},
                {9, 7},
                {10, 7}, {11, 10}});
        int[] ints = Arrays.stream(table).filter(i -> i < 20001).toArray();
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    public static int solution(int n, int[][] edge) {
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edge.length; i++) {
            //양방향이므로 2개
            list.get(edge[i][0]).add(new Node(edge[i][1], 1));
            list.get(edge[i][1]).add(new Node(edge[i][0], 1));

        }
        Arrays.fill(table, 20001);
        al();
        int max = Arrays.stream(table).filter(i -> i < 20001).max().getAsInt();
        int count = (int) Arrays.stream(table).filter(i -> i == max).count();
        System.out.println("count = " + count);
        return count;
    }

    public static void al() {
        PriorityQueue<Node> heap = new PriorityQueue<>();
        table[1] = 0;
        heap.offer(new Node(1, 0));
        while (!heap.isEmpty()) {
            Node poll = heap.poll();
            int cost = poll.cost;
            int index = poll.index;
            if (cost > table[index]) continue;
            for (int i = 0; i < list.get(index).size(); i++) {
                Node node = list.get(index).get(i);
                int newIndex = node.index;
                int newCost = node.cost + table[index];
                if (table[newIndex] > newCost) {
                    table[newIndex] = newCost;
                    heap.offer(new Node(newIndex, newCost));
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
            if (this.cost < node.cost) {
                return -1;
            }
            return 1;
        }
    }
}
