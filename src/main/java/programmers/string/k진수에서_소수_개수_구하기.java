package programmers.string;

/**
 * packageName :  programmers.string
 * fileName : k진수에서_소수_개수_구하기
 * author :  ddh96
 * date : 2023-03-29 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/92335
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-03-29                ddh96             최초 생성
 */
public class k진수에서_소수_개수_구하기 {
    public static void main(String[] args) {
        k진수에서_소수_개수_구하기 test = new k진수에서_소수_개수_구하기();
        int solution = test.solution(934333, 3);
        System.out.println("solution = " + solution);
    }

    public String dedupe(String str) {
        String result = ""; // 결과를 저장할 빈 문자열
        char prev = ' '; // 이전에 방문한 문자를 저장할 변수
        for (char c : str.toCharArray()) { // 문자열의 각 문자에 대해
            if (c != '0' || prev != '0') { // 현재 문자가 0이 아니거나 이전 문자가 0이 아니면
                result += c; // 결과에 추가
            }
            prev = c; // 이전 문자를 현재 문자로 갱신
        }
        return result;
    }

    public int solution(int n, int k) {
        int answer = 0;
        String dedupe = dedupe(Integer.toString(n, k));
        String[] number = dedupe.split("0");
        for (String s : number) {
            System.out.println("s = " + s);
            if (isPrime(Long.parseLong(s))) {
                answer++;
            }
        }

        return answer;
    }

    public boolean isPrime(long n) {
        if (n < 2) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
