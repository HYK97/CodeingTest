package algorithm.grapsearch;

import java.util.ArrayList;
import java.util.List;

public class DFS {
    static int N = 9;
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
        //1부터시작
        dfs(1);
    }

    private static void dfs(int i) {
        check[i] = true;
        System.out.print(i + " ");
        //for 문으로 현재 i의 값 시작 점을 중심으로 연결된 노드들을 한개씩 방문하는데 이때 방문하지않은 노드들의 만 방문하도록 if문을 이용함
        for (int j = 0; j < graph.get(i).size(); j++) {
            int y = graph.get(i).get(j);
            if (!check[y]) {
                dfs(y);
                //check[i]=false;
                //뒤에 추가적인 로직이 필요할때 -> 백로깅
            }
        }
    }
}
