package programmers.stack_queue;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * packageName :  programmers.stack_queue
 * fileName : 기능개발다른풀이
 * author :  ddh96
 * date : 2022-12-23 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-23                ddh96             최초 생성
 */
public class 기능개발다른풀이 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> jobs = new LinkedList<>();
        Arrays.stream(progresses).forEach(jobs::offer);
        Map<Integer, Integer> day = new LinkedHashMap<>();
        int currentDay = 1;
        int currentJob = jobs.poll();
        int jobIndex = 0;
        while (!jobs.isEmpty()) {
            if (currentJob + (speeds[jobIndex] * currentDay) >= 100) {
                if (day.containsKey(currentDay)) {
                    day.put(currentDay, day.get(currentDay) + 1);
                } else {
                    day.put(currentDay, 1);
                }
                currentJob = jobs.poll();
                jobIndex++;
            } else {
                currentDay++;
            }
        }
        while (true) {
            if (currentJob + (speeds[jobIndex] * currentDay) >= 100) {
                if (day.containsKey(currentDay)) {
                    day.put(currentDay, day.get(currentDay) + 1);
                } else {
                    day.put(currentDay, 1);
                }
                break;
            } else {
                currentDay++;
            }
        }
        Collection<Integer> values = day.values();
        return values.stream().mapToInt(Integer::valueOf).toArray();
    }
}
