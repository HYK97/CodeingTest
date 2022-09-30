package programmers.sort;

import java.util.Arrays;

public class H_Index {
    //n 편중 H 번 이상 인용된 논문이 H편 이상
    //나머지 논문이 H번ㅇ이하

    public static void main(String[] args) {
        H_Index h = new H_Index();
        System.out.println(h.solution(new int[]{3, 0, 6, 1, 5}));
        //index 첫번째의 논문의 인용수가 -> index 이상편인지 물어보는것.
        //0,1,3,5,6
    }

    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        // H 의 최댓값을 구해야함.
        //                |-> 어차피 다 true이기 떄문에 break로 맊음
        //data        0 1 3 5 6
        //h           5 4 3 2 1
        //boolean     f f t t t  break;

        //data        3 4 5 8 10
        //h           5 4 3 2 1
        //boolean     f t t t t

        return answer;
    }

}
