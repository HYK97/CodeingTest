package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName :  quiz
 * fileName : 도시분할계획
 * author :  ddh96
 * date : 2022-11-15
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-15                ddh96             최초 생성
 */
public class 도시분할계획 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]); // 집의 개수
        int M = Integer.parseInt(s[1]); // 길의 개수
        int[] table = new int[100001];
        int result = 0;
        for (int i = 0; i <= N; i++) {
            table[i] = i;
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int a = Integer.parseInt(s1[0]); // 집의 개수
            int b = Integer.parseInt(s1[1]); // 길의 개수
            int cost = Integer.parseInt(s1[2]);
            list.add(new Edge(a, b, cost));
        }

        Collections.sort(list);

        int maxCost = 0;
        for (Edge edge : list) {
            int nodeA = findSet(edge.getNodeA(), table);
            int nodeB = findSet(edge.getNodeB(), table);
            if (nodeA != nodeB) {
                result += edge.getCost();
                // 정렬 되어있어서 마지막에 추가된 노드의 비용이 가장크기때문에 다음과같이 진행하면된다
                maxCost = edge.getCost();
                union(nodeA, nodeB, table);
            }
        }

        System.out.println(result - maxCost);
    }

    public static void union(int nodeA, int nodeB, int[] table) {
        if (nodeA > nodeB) {
            table[nodeB] = nodeA;
        } else {
            table[nodeA] = nodeB;
        }
    }

    public static int findSet(int node, int[] table) {
        if (node != table[node]) {
            table[node] = findSet(table[node], table);
        }
        return table[node];
    }

    static class Edge implements Comparable<Edge> {

        int nodeA;
        int nodeB;
        int cost;

        public Edge(int nodeA, int nodeB, int cost) {
            this.nodeA = nodeA;
            this.nodeB = nodeB;
            this.cost = cost;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        public int getCost() {
            return cost;
        }

        @Override
        public int compareTo(Edge edge) {
            if (this.cost < edge.cost) {
                return -1;
            } else if (this.cost > edge.cost) {
                return 1;
            } else { //IllegalArgument 방지
                return 0;
            }

        }
    }
}
