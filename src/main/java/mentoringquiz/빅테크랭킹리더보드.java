package mentoringquiz;

import java.util.Comparator;
import java.util.TreeMap;

public class 빅테크랭킹리더보드 {
    TreeMap<Integer, String> rankingChart = new TreeMap<>(Comparator.reverseOrder()); ///(new TreeMap<>(Collections.reverseOrder()));

    public static void main(String[] args) {
        빅테크랭킹리더보드 t = new 빅테크랭킹리더보드();
        String[] name = {"a", "b", "c", "d"};
        int[] score = {32, 33, 29, 35};
        for (int i = 0; i < 4; i++) {
            t.putUser(name[i], score[i]);
        }
        System.out.println(t.getName(1));
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
        if (rank == 0 || rankingChart.size() < rank) {
            throw new IllegalArgumentException("잘못된인수");
        }
        int count = 1;
        String name = null;
        for (Integer integer : rankingChart.keySet()) {
            if (count == rank) {
                name = rankingChart.get(integer);
            }
            count++;
        }

        return name;
    }

    public void putUser(String name, int score) {
        rankingChart.put(score, name);
    }
}
