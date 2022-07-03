package baekjoon;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class No11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> que = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());

            while (!que.isEmpty() && que.peekLast().data > now) {
                que.removeLast();
            }

            que.addLast(new Node(i, now));
            if (que.peekFirst().index <= i - L) {
                que.removeFirst();
            }
            bw.write(que.peekFirst().data + " ");
        }
        bw.flush();
    }

    private static class Node {
        int index;
        int data;

        public Node(int index, int data) {
            this.index = index;
            this.data = data;
        }
    }
}
