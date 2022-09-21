package baekjoon;


import java.io.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class No15650 {
    static int N;
    static int M;
    static HashSet<Integer> data = new HashSet<>();
    static boolean[] check;
    static Set<HashSet<Integer>> set = new LinkedHashSet<>();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        N = Integer.parseInt(s[0]);
        M = Integer.parseInt(s[1]);
        check = new boolean[N + 1];
        tracking(0);
        for (HashSet<Integer> data : set) {
            if (data.size() == M) {
                for (int datum : data) {
                    if (datum != 0) {
                        bw.write(datum + " ");
                    }
                }
                bw.write("\n");
            }
        }
        bw.flush();
    }

    public static void tracking(int depth) {
        if (depth == M) {
            set.add(new HashSet<>(data));
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (!check[i]) {
                data.add(i);
                check[i] = true;
                tracking(depth + 1);
                data.remove(i);
                check[i] = false;
            }
        }
    }
}
