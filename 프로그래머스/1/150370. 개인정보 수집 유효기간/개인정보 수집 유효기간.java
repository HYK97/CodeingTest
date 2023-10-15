import java.util.*;
import java.time.*; 
class Solution {

    public int[] solution(String today, String[] terms, String[] privacies) {
        Integer[] todayArray = getArray(today);
        LocalDate todayLocalDate=LocalDate.of(todayArray[0],todayArray[1],todayArray[2]);
        Map<String,LocalDate> termMap = new HashMap<>();
        for (String term : terms) {
            String[] split = term.split(" ");
            String termsCh = split[0];
            int termsMonth = Integer.parseInt(split[1]);
            termMap.put(termsCh,todayLocalDate.minusMonths(termsMonth));
        }
   
        List<Integer> answerList = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] split = privacy.split(" ");
            Integer[] privacyDateArray = getArray(split[0]);
            LocalDate privacyDate = LocalDate.of(privacyDateArray[0], privacyDateArray[1], privacyDateArray[2]);
            String privacyTerms = split[1];
            LocalDate localDate = termMap.get(privacyTerms);
            if (localDate.isAfter(privacyDate)||localDate.isEqual(privacyDate)) {
                answerList.add(i+1);
            }
        }

        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }

    private static Integer[] getArray(String split) {
        return Arrays.stream(split.split("\\.")).map(Integer::parseInt).toArray(Integer[]::new);
    }
}