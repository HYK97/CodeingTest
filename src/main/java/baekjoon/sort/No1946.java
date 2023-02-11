package baekjoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No1946 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            PriorityQueue<Data> rank = new PriorityQueue<>(Comparator.comparingInt(a -> a.a));
            int count2 = Integer.parseInt(br.readLine());
            for (int j = 0; j < count2; j++) {
                String[] s = br.readLine().split(" ");
                rank.add(new Data(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
            }

            int answer = 1;
            int currentRank = rank.poll().b;

            while (!rank.isEmpty()) {
                Data nextRank = rank.poll();
                if (currentRank > nextRank.b) {
                    answer++;
                    currentRank = nextRank.b;
                }
            }
            System.out.println(answer);
        }
    }

    static class Data {
        int a;
        int b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
