class Solution {
    public int hIndex(int[] citations) {
        Integer [] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
        for (int i = 0 ; i < tmp.length ; i ++) {
            if (tmp[i] < i + 1) {
                return i;
            }
        }
        return tmp.length;
    }
}