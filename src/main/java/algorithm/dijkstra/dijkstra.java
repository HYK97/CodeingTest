package algorithm.dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class dijkstra {

    static List<List<Node>> graph = new ArrayList<>();


    static int nodeCount;
    static int linkCount;


    static int[] table = new int[100000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        nodeCount = Integer.parseInt(s[0]);
        linkCount = Integer.parseInt(s[1]);
        int startNode = Integer.parseInt(br.readLine());
        for (int i = 0; i < linkCount; i++) {
            graph.add(new ArrayList<>());
        }
        Arrays.fill(table, Integer.MAX_VALUE);
        for (int i = 0; i < linkCount; i++) {
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(s1[0]).add(new Node(s1[1], s1[2]));
        }
        dijkstra(startNode);
        for (int i = 1; i <= nodeCount; i++) {
            // 도달할 수 없는 경우, 무한(INFINITY)이라고 출력
            if (table[i] == Integer.MAX_VALUE) {
                System.out.println("INFINITY");
            }
            // 도달할 수 있는 경우 거리를 출력
            else {
                System.out.println(table[i]);
            }
        }
    }


    /**
     * 시작점         종료점 + cost
     * i             list(index,cost)
     * 0
     * 1          node(2,2),node(3,5),node(4,1)
     * 2          node(3,3),node(4,2)
     * 3
     */


    public static void dijkstra(int start) {
        // 우선순위 큐 생성
        PriorityQueue<Node> heap = new PriorityQueue<>();

        // 시작 초기화 -> 저장되는 테이블과 큐에 한개씩 넣어줌
        table[start] = 0;
        heap.offer(new Node(start, 0));
        while (!heap.isEmpty()) {    //큐가 빌때까지 반복
            //한개의 큐를꺼내서 각각 node의 비용과 index를 까내줌
            Node poll = heap.poll();
            int index = poll.index;
            int cost = poll.cost;


            // 우선순위큐 node(인덱스 2 : 비용 4)    현재 저장된 테이블  인덱스 2 비용 3 일 경우에 -> 우선순위큐 내부의 node와
            // 테이블의 비용을 비교했을때 우선순위큐 비용이 더크면 해당 노드는 방문 한걸로 판별
            if (table[index] < cost) continue; //만약에 저장 테이블의 값(총비용) 보다 cost가 클경우에는 이미 해당 노드는 방문한것으로 판별함


            //각각의 노드에 접근해 한개씩 확인하는코드
            /**
             *
             * 현재코드
             * index
             *                 i cost    i cost    i cost
             * 1          node(2,2),node(3,5),node(4,1)      -> 즉 get index의 list 크기만큼 반복문을 돌려서 현재 1번 인덱슥다 3개인경우 3번의 모든 인접한 노드들을 확인하는코드
             * 2          node(3,3),node(4,2)
             * 3
             */

            for (int i = 0; i < graph.get(index).size(); i++) {
                Node node = graph.get(index).get(i);
                int newCost = node.cost + table[index]; //현재 index ~  노드 index(new index) 까지의 비용 에다가 시작점에서 현재 index까지의 비용이 저장된 table의 값을 더해서
                // start에서 new index까지의 비용을 구함
                int newIndex = node.index;
                if (table[newIndex] > newCost) { //만약에 저장되있는 값이 새로 계산한 비용보다 작을 경우 교체하고 현재 노드의 비교한노드와 비용을 큐에다가 넣음.
                    table[newIndex] = newCost;
                    node.cost = newCost;
                    heap.offer(new Node(newIndex, newCost));
                    /*
                     *  node.cost = newCost;
                     *    heap.offer(node);
                     * */
                }
            }
        }
    }


    static class Node implements Comparable<Node> {
        private int cost; // 비용
        private int index;// 현재 나의 위치  ex 1번 node

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node node) {
            if (this.cost < node.cost) {
                return -1;
            } else {
                return 1;
            }
        }
    }


    /**   테스트 값
     * 6 11
     * 1
     * 1 2 2
     * 1 3 5
     * 1 4 1
     * 2 3 3
     * 2 4 2
     * 3 2 3
     * 3 6 5
     * 4 3 3
     * 4 5 1
     * 5 3 1
     * 5 6 2
     * */


}
