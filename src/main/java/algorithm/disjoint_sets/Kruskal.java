package algorithm.disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * packageName :  algorithm.disjoint_sets
 * fileName : Kruskal
 * author :  ddh96
 * date : 2022-11-14
 * description : 크루스칼 알고리즘
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-14                ddh96             최초 생성
 */
public class Kruskal {


    public static void main(String[] args) throws IOException {
        List<Edge> list = new ArrayList<>();
        int[] table = new int[100000];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int v = Integer.parseInt(s[0]); // 노드수
        int e = Integer.parseInt(s[1]); // 간선수
        for (int i = 0; i < e; i++) {
            String[] s1 = br.readLine().split(" ");
            int distance = Integer.parseInt(s1[2]);
            int a = Integer.parseInt(s1[0]);
            int b = Integer.parseInt(s1[1]);
            list.add(new Edge(distance, a, b));
        }
        for (int i = 1; i <= v; i++) {
            table[i] = i;
        }
        Collections.sort(list);

        int result = 0;
        for (int i = 0; i < e; i++) { // 모든 간선들을 확인함

            int nodeA = list.get(i).getNodeA();
            int nodeB = list.get(i).getNodeB();

            int parentA = findParent(nodeA, table); //각각의 부모노드를 확인하기
            int parentB = findParent(nodeB, table);
            if (parentA != parentB) { // 부모 노드가 같은 집합이 아닐경우
                union(parentA, parentB, table); // 집합 합치기 수행
                result += list.get(i).distance;
            }
        }
        System.out.println("result = " + result);
    }

    private static void union(int nodeA, int nodeB, int[] table) {
        if (table[nodeA] > table[nodeB]) {
            table[nodeA] = table[nodeB];
        } else {
            table[nodeB] = table[nodeA];
        }
    }

    private static int findParent(int data, int[] table) {
        if (data != table[data]) {
            return findParent(table[data], table);
        }
        return table[data];
    }

    static class Edge implements Comparable<Edge> {

        private int distance;
        private int nodeA;
        private int nodeB;


        public Edge(int distance, int nodeA, int nodeB) {
            this.distance = distance;
            this.nodeA = nodeA;
            this.nodeB = nodeB;
        }

        public int getDistance() {
            return distance;
        }

        public int getNodeA() {
            return nodeA;
        }

        public int getNodeB() {
            return nodeB;
        }

        @Override
        public int compareTo(Edge edge) {
            // 현재의 거리보다 매개변수edge 의 거리 값이 더 클경우 현재의 edge의 우선순위를 더 높게 가지도록 설정
            if (this.distance < edge.distance) {
                return -1;
            }
            return 1;
        }
    }


}
