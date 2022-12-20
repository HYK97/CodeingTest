package naver_intern;

/**
 * packageName :  naver_intern
 * fileName : No15_Greedy
 * author :  ddh96
 * date : 2022-12-16 
 * description : https://school.programmers.co.kr/learn/courses/30/lessons/42860
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-16                ddh96             최초 생성
 */
public class No15_Greedy {

    public int solution(String name) {
        int answer = 0;
        char data[] = name.toCharArray();
        int nameLength = name.length();
        int scollCount = nameLength - 1;
        for (int i = 0; i < nameLength; i++) {
            answer += 13 - Math.abs('N' - data[i]);

            int nextIndex = i + 1;
            while (nextIndex < nameLength && name.charAt(nextIndex) == 'A') {
                nextIndex++;
            }
            //다음 인덱스가 A 이고 연속된 A가 끝나는 마지막 A까지의 범위를 구함
            //          dsds  s<-aaa-> sdsbd
            //                i    ↑ -> nextIndex
            //          dsds/aaaa/b  /aaa/ sdsbd
            //               ↑  ↑     ↑ ↑         이렇게 연속되는 a가 두번있는경우는
            //              i가 s일때  i가 b일때 한번씩 돌아서 최소를 구한다.
            scollCount = Math.min(scollCount, (i * 2) + nameLength - nextIndex);
            scollCount = Math.min(scollCount, (nameLength - nextIndex) * 2 + i);
        }

        return answer + scollCount;
    }

}

