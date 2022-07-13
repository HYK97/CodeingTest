package programmers.hash;

import java.util.*;

public class 베스트앨범 {
    public static void main(String[] args) {
        int[] solution = solution(new String[]{"a", "b", "b", "c", "c"}, new int[]{5, 5, 40, 5, 5});
    }

    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresMap = new HashMap<>();
        Map<Integer, Integer> playsMap = new HashMap<>();

        //1단계 속한 노래가 가장 많이 재생된 장르 - > 장르의 개수를 map으로 count
        //2단계 장르내 많이 재생된노래 확인 -> genres 별 plays[i] 중 가장 많이된것 1,2 위
        //3단계 재생횟수가 같은노래중 고유번호가 낮은노래 먼저수록

        for (int i = 0; i < genres.length; i++) {
            playsMap.put(i, plays[i]);
            if (genresMap.containsKey(genres[i])) {
                genresMap.put(genres[i], genresMap.get(genres[i]) + plays[i]);
            } else {
                genresMap.put(genres[i], plays[i]);
            }
        }
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(genresMap.entrySet());
        entryList.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        List<Map.Entry<Integer, Integer>> entryList2 = new LinkedList<>(playsMap.entrySet());
        entryList2.sort(new Comparator<>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });

        int flag = 0;
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<String, Integer> s1 : entryList) {
            for (Map.Entry<Integer, Integer> s2 : entryList2) {
                if (flag == 2) {
                    break;
                }
                if (s1.getKey().equals(genres[s2.getKey()])) {
                    result.add(s2.getKey());
                    flag++;
                }
            }
            flag = 0;
        }
        int[] answer = result.stream().mapToInt(i -> i).toArray();
        System.out.println("answer = " + result);
        return answer;
    }
}
