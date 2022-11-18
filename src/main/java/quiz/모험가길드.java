package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * packageName :  quiz
 * fileName : 모험가길드
 * author :  ddh96
 * date : 2022-11-18
 * description : 기본 그리디 문제
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-18                ddh96             최초 생성
 */
public class 모험가길드 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] sorted = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::valueOf).toArray();
        Arrays.sort(sorted);
        //1 2 2 2 3
        //오름차순으로 정렬 한뒤에
        int group = 0;
        int groupUser = 0;
        for (int i = 0; i < sorted.length; i++) {  //sorted[i] -> 현재 모험가의 공포도
            groupUser++;
            if (sorted[i] <= groupUser) { //현재 모험가의 공포도가 현재 그룹의 유저 수 보다 작거나 같으면 그룹을 생성
                group++;
                groupUser = 0;            //그룹 유저수 초기화
            }
        }
        System.out.println("group = " + group);

    }
}
