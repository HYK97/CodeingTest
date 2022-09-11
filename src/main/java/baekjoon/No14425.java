package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class No14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NandM = br.readLine().split(" ");
        int N = Integer.parseInt(NandM[0]);
        int M = Integer.parseInt(NandM[1]);
        HashSet<String> set = new HashSet<>();
        String[] Mdata = new String[M];
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        for (int i = 0; i < M; i++) {
            Mdata[i] = br.readLine();
        }

        int count = 0;
        for (String mdatum : Mdata) {
            if (set.contains(mdatum)) {
                count++;
            }
        }
        System.out.println(count);

    }

}

