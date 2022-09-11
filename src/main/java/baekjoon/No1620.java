package baekjoon;

import java.io.*;
import java.util.HashMap;

public class No1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] NandM = br.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);
        HashMap<String, String> set = new HashMap<>();
        HashMap<String, String> set2 = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String value = br.readLine();
            set.put(String.valueOf(i), value);
            set2.put(value, String.valueOf(i));
        }

        for (int i = 0; i < M; i++) {
            String temp = br.readLine();
            String key = set.get(temp);
            if (key != null) {
                bw.write(key + "\n");
                continue;
            }
            String key2 = set2.get(temp);
            if (key2 != null) {
                bw.write(key2 + "\n");
            }
        }
        bw.flush();
        bw.close();

    }

}

