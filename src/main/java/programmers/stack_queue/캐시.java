package programmers.stack_queue;

import java.util.LinkedHashSet;

/**
 * packageName :  programmers.stack_queue
 * fileName : 캐시
 * author :  ddh96
 * date : 2023-03-29 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/17680
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-29                ddh96             최초 생성
 */
public class 캐시 {
    static LinkedHashSet<String> cache;
    static int currentSize = 0;
    static int initSize = 0;

    public static void main(String[] args) {
        int solution = solution(3,
            new String[] {"Jeju", "Jeju", "NewYork", "NewYork", "ㄴㄴ", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"});
        System.out.println("solution = " + solution);
    }

    public static int solution(int cacheSize, String[] cities) {
        int answer = 0;

        initSize = cacheSize;
        cache = new LinkedHashSet<>();

        for (String city : cities) { // 여기서 남은것들 넣음 근데 캐시가있으면 5초 더하고 있으면 1초 더함
            boolean search = search(city.toLowerCase());
            if (initSize == 0) {
                answer += 5;
                continue;
            }
            if (search) {
                answer += 1;
            } else {
                answer += 5;
            }
            for (String s : cache) {
                System.out.println("s = " + s);
            }
            System.out.println(" ====+" + answer + "+===== ");
        }

        return answer;
    }

    private static boolean search(String city) {
        if (cache.contains(city)) { // 키가있는경우
            cache.remove(city);        // 현재키  삭제
            cache.add(city);     // 맨위로 put
            return true;
        } else {
            if (currentSize < initSize) { // 현재 사이즈가 캐시사이즈 보다 작은경우
                cache.add(city);
                currentSize++;
            } else {  // 현재 사이즈가 캐시사이즈 보다 큰경우
                if (cache.iterator().hasNext()) { // 캐시가 비어있지 않은경우
                    cache.remove(cache.iterator().next()); // 맨마지막꺼 삭제
                }
                cache.add(city);
            }
            return false;
        }

    }
}
