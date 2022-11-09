package algorithm.disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName :  algorithm.disjoint_sets
 * fileName : NonDirectionCycle
 * author :  ddh96
 * date : 2022-11-09
 * description : 무방향 그래프 사이클 확인
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-09                ddh96             최초 생성
 */
public class NonDirectionCycle {
    static int[] table;
    static int N; //노드수
    static int V; //간선수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        V = Integer.parseInt(s[1]);
        table = new int[N + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = i;
        }
        boolean cycle = false;
        for (int i = 0; i < V; i++) {
            String[] data = br.readLine().split(" ");
            int i1 = Integer.parseInt(data[0]);
            int i2 = Integer.parseInt(data[1]);
            if (findParent(i1) == findParent(i2)) { // 부모가 같으면 cycle 이 발생하는 것으로 취급
                cycle = true;
                break;
            } else {
                union(i1, i2);
            }
        }
        if (cycle) {
            System.out.println("사이클o");
        } else {
            System.out.println("사이클x");
        }

    }

    public static void union(int data1, int data2) {
        int parent = findParent(data1);
        int parent2 = findParent(data2);
        if (parent > parent2) {
            table[parent] = parent2;
        } else {
            table[parent2] = parent;
        }
    }

    public static int findParent(int data) {
        // 자기자신이 아니라면
        if (data != table[data]) {
            table[data] = findParent(table[data]);
        }
        return table[data];
    }
}
