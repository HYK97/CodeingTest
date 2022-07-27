package mentoringquiz;

import java.util.Collections;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class 빅테크랭킹리더보드 {
    SortedMap<Integer, String> rankingChart = Collections.synchronizedSortedMap(new TreeMap<>(Collections.reverseOrder()));

    public static void main(String[] args) {
        빅테크랭킹리더보드 t = new 빅테크랭킹리더보드();
        String[] name = {"a", "b", "c", "d"};
        int[] score = {32, 33, 29, 35};
        for (int i = 0; i < 4; i++) {
            t.putUser(name[i], score[i]);
        }
        System.out.println(t.getName(2));
        System.out.println(t.getRank("d"));
    }

    public int getRank(String name) {
        int ranking = 1;
        if (!rankingChart.containsValue(name)) {
            throw new IllegalArgumentException("잘못된인수");
        }
        for (Integer integer : rankingChart.keySet()) {
            if (name.equals(rankingChart.get(integer))) {
                break;
            }
            ranking++;
        }
        return ranking;
    }

    public String getName(int rank) {
        if (rank == 0) {
            throw new IllegalArgumentException("잘못된인수");
        }
        List<String> values = rankingChart.values().stream().collect(Collectors.toList());
        return values.get(rank - 1);
    }

    public void putUser(String name, int score) {
        rankingChart.put(score, name);
    }
}
