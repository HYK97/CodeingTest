class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }

        // EntrySet을 리스트로 변환
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());

        // 값 기준으로 정렬
        entries.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // 정렬된 결과를 LinkedHashMap으로 다시 저장
        LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> entry : entries) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        int index = 0;
        int[] result = new int[k];
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            if (index == k) {
                break;
            }
            result[index] = entry.getKey();
            index++;
        }
        return result;
    }
}