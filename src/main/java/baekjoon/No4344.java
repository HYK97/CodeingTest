package baekjoon;

import java.io.*;

public class No4344 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ban = Integer.parseInt(br.readLine());
        int[][] data = new int[ban][];
        double[] result = new double[ban];
        for (int i = 0; i < ban; i++) {
            String s = br.readLine();
            String[] split = s.split(" ");
            data[i] = new int[Integer.parseInt(split[0])];
            for (int j = 0; j < Integer.parseInt(split[0]); j++) {
                if (j + 1 < split.length) {
                    data[i][j] = Integer.parseInt(split[j + 1]);
                    result[i] += Integer.parseInt(split[j + 1]);
                }
                if (j == Integer.parseInt(split[0]) - 1) {
                    result[i] = result[i] / Integer.parseInt(split[0]);
                }
            }
        }


        for (int i = 0; i < data.length; i++) {
            int count = 0;
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > result[i]) {
                    count++;
                }
            }
            result[i] = ((double) count / (double) data[i].length) * 100.0;
            bw.write(String.format("%.3f", result[i]) + "%\n");
        }
        bw.flush();

    }

}
