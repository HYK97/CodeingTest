package programmers.binarysearch;

/**
 * packageName :  programmers.binarysearch
 * fileName : 징검다리_건너기
 * author :  ddh96
 * date : 2023-04-12 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/64062
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-12                ddh96             최초 생성
 */
public class 징검다리_건너기 {
    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200000000;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (isPossible(stones, k, mid)) {
                answer = Math.max(mid, answer);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }

    public boolean isPossible(int[] stones, int k, int mid) {
        int count = 0;
        for (int stone : stones) {

            //ex -> mid = 5 모든 돌에서 5를 빼서 5명 많큼 못건널시에는 mid를 줄여서 돌린다
            if (stone - mid < 0) { // mid 를 빼는 이유는 mid를 건널인원으로 생각 하고 mid 보다작은 경우 더 작은 인원만 건널수있기 때문에 count를 더해준다.
                count++;
            } else {
                count = 0;
            }
            if (k == count) {
                return false;
            }
        }
        return true;

    }
}
