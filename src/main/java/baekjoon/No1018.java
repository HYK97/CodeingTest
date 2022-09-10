package baekjoon;

import java.io.*;

public class No1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] s = br.readLine().split(" ");
        int y = Integer.parseInt(s[0]);
        int x = Integer.parseInt(s[1]);
        String[][] data = new String[y][x];
        for (int i = 0; i < y; i++) {
            String[] split = br.readLine().split("");
            for (int j = 0; j < x; j++) {
                data[i][j] = split[j];
            }
        }


        String[] a = new String[]{"W", "B", "W", "B", "W", "B", "W", "B"};
        String[] b = new String[]{"B", "W", "B", "W", "B", "W", "B", "W"};
        int count1 = 0;
        int count2 = 0;
        int x1 = 0;
        int x2 = 7;
        int y1 = 0;
        int y2 = 7;
        int result = 999999;
        int k = 0;
        while (y2 < data.length && x2 < data[1].length) {
            while (x2 < data[1].length) {
                for (int i = y1; i <= y2; i++) {
                    for (int j = x1; j <= x2; j++) {
                        if (i % 2 == 0) {
                            if (!a[k].equals(data[i][j])) {
                                count1++;
                            }
                            if (!b[k].equals(data[i][j])) {
                                count2++;
                            }
                            k++;
                        } else {
                            if (!b[k].equals(data[i][j])) {
                                count1++;
                            }
                            if (!a[k].equals(data[i][j])) {
                                count2++;
                            }
                            k++;
                        }
                    }
                    k = 0;
                }
                x1++;
                x2++;
                result = Math.min(result, Math.min(count1, count2));
                count1 = 0;
                count2 = 0;
            }
            x1 = 0;
            x2 = 7;
            y1++;
            y2++;
        }
        System.out.println(result);
    }

}

