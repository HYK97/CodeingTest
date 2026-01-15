class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        if (citations.length == 1 && citations[0] == 0){
            return 0;
        }
        for (int i = 0 ; i < citations.length ; i ++){
            if (citations[i] == i + 1){
                return citations[i];
            }
        }
        return 1;
    }
}