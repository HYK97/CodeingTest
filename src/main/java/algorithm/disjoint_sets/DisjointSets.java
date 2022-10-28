package algorithm.disjoint_sets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//서로소 집합
public class DisjointSets {

    static int[] table;
    static int N;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        V = Integer.parseInt(s[1]);
        table = new int[N + 1];
        for (int i = 1; i < table.length; i++) {
            table[i] = i;
        }


        for (int i = 0; i < V; i++) {
            String[] data = br.readLine().split(" ");
            int i1 = Integer.parseInt(data[0]);
            int i2 = Integer.parseInt(data[1]);
            union(i1, i2);
        }

        for (int i : table) {
            System.out.println(findParent(i));
        }


    }

    public static void union(int data1, int data2) {
        int a = findParent(data1);
        int b = findParent(data2);
        if (a < b) {
            table[b] = a;
        } else {
            table[a] = b;
        }

    }


    public static int findParent(int data) {
        if (table[data] != data) {
            table[data] = findParent(table[data]);
        }
        return table[data];
    }

}
