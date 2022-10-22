package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class 전보 {


    static int cityCount;
    static int lineCount;

    static List<List<City>> graph = new ArrayList<>();

    static int[] table = new int[30001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        cityCount = Integer.parseInt(s[0]);
        lineCount = Integer.parseInt(s[1]);
        int startCity = Integer.parseInt(s[2]);
        Arrays.fill(table, Integer.MAX_VALUE);

        for (int i = 0; i <= cityCount; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < lineCount; i++) {
            int[] s1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(s1[0]).add(new City(s1[1], s1[2]));
        }
        solution(startCity);

        long count = Arrays.stream(table).filter(i -> i < Integer.MAX_VALUE).count() - 1;
        int maxTime = Arrays.stream(table).filter(i -> i < Integer.MAX_VALUE).max().getAsInt();
        System.out.println(count + " " + maxTime);

    }


    public static void solution(int start) {
        PriorityQueue<City> heap = new PriorityQueue<>();
        table[start] = 0;
        heap.offer(new City(start, 0));
        while (!heap.isEmpty()) {
            City poll = heap.poll();
            int targetCity = poll.targetCity;
            int time = poll.time;
            if (time > table[targetCity]) continue;
            for (int i = 0; i < graph.get(targetCity).size(); i++) {
                City city = graph.get(targetCity).get(i);
                int forEachTarget = city.targetCity;
                int newTime = city.time + table[targetCity];
                if (table[forEachTarget] > newTime) {
                    table[forEachTarget] = newTime;
                    if (graph.get(forEachTarget).size() > 0) {
                        heap.offer(new City(forEachTarget, newTime));
                    }
                }
            }
        }


    }

    static class City implements Comparable<City> {
        int targetCity;
        int time;

        public City(int cityIndex, int time) {
            this.targetCity = cityIndex;
            this.time = time;
        }


        @Override
        public int compareTo(City city) {
            if (this.time < city.time) {
                return -1;
            }
            return 1;


        }
    }
}
