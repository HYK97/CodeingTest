package baekjoon;


import java.io.*;
import java.util.PriorityQueue;


public class No2751 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> array = new PriorityQueue<>();

        for (int j = 0; j < n; j++) {
            if (br.readLine() != null) {
                int i2 = Integer.parseInt(br.readLine());
                array.add(i2);
            }
        }
        while (!array.isEmpty()) {
            sb.append(array.poll()).append('\n');
        }
        sb.delete(sb.length() - 1, sb.length());
        bw.write(String.valueOf(sb));
        bw.flush();
    }
}
