package programmers.greedy;

/**
 * packageName :  programmers.greedy
 * fileName : 기지국_설치
 * author :  ddh96
 * date : 2023-03-30 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/12979
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-30                ddh96             최초 생성
 */
public class 기지국_설치 {
    public static void main(String[] args) {
        int solution = solution(11, new int[] {4, 11}, 1);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int range = 2 * w + 1;
        int uncoveredStart = 0; //0 부터 시작

        for (int station : stations) { // => 다음 station range 맨앞 과 이전 station range 맨뒤를 가져와서 range로 설정
            int stationCoverageStart = station - w - 1;  // 시작 인덱스
            int stationCoverageEnd = station + w - 1; // 종료 인덱스

            if (uncoveredStart < stationCoverageStart) {//시작접과 종료점이 겹치지 않는다면
                int uncoveredRange = stationCoverageStart - uncoveredStart; // 시작점과 종료점 사이의 거리
                answer += Math.ceil((double)uncoveredRange / range);//범위에서 range로 나눈몫을 올림처리
            }
            uncoveredStart = stationCoverageEnd + 1;
        }

        if (uncoveredStart < n) {
            int uncoveredRange = n - uncoveredStart;
            answer += (uncoveredRange + range - 1) / range;
        }

        return answer;
    }
}