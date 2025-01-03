import java.util.Arrays;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = Arrays.stream(diffs).max().getAsInt();

        while (start < end) {
            int level = (start + end) / 2;
            long totalTime = getTotalTime(diffs, times, level);

            if (limit >= totalTime) {
                end = level;
            } else {
                start = level + 1;
            }
        }
        return end;
    }

    private static long getTotalTime(int[] diffs, int[] times, int middle) {
        long totalTime = 0;
        for (int i = 0; i < diffs.length; i++) {
            int count = diffs[i] - middle;
            if (count <= 0) {
                totalTime += times[i];
                continue;
            }
            int timePrev = i == 0 ? 0 : times[i - 1];
            int executionTime = times[i];
            totalTime += (timePrev + executionTime) * count + executionTime;
        }
        return totalTime;
    }
}
