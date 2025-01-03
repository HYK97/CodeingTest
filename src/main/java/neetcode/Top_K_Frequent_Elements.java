package neetcode;

import java.util.*;

public class Top_K_Frequent_Elements {
    public static void main(String[] args) {
        Top_K_Frequent_Elements topKFrequentElements = new Top_K_Frequent_Elements();
        int[] ints = topKFrequentElements.topKFrequent(new int[]{1, 2, 2, 3, 3, 3}, 2);
        System.out.println("ints = " + ints);
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        Map<Integer, Integer> counting = new HashMap<>();
        for (int num : nums) {
            counting.merge(num, 1, Integer::sum);
        }
        List<Integer> keySet = new ArrayList<>(counting.keySet());
        keySet.sort(Comparator.comparing(counting::get).reversed());
        for (int i = 0; i < k; i++) {
            result[i] = keySet.get(i);
        }
        return result;
    }
}
