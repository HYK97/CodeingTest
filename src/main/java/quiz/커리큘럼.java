package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * packageName :  quiz
 * fileName : 커리큘럼
 * author :  ddh96
 * date : 2022-11-16
 * description : 위상 정렬 이용
 * 아이디어 선수 수강 과목중 가장 오래걸리는 강의 + 현재강의
 * 다만 같은 DEPTH 여야한다.
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-16                ddh96             최초 생성
 */
public class 커리큘럼 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();
        int[] table = new int[N + 1];
        int[] timeTable = new int[N + 1];
        int[] result = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            String[] s = br.readLine().split(" ");
            int time = Integer.parseInt(s[0]);
            timeTable[i] = time;
            result[i] = time;
            for (int j = 1; j < s.length - 1; j++) {
                if (-1 == Integer.parseInt(s[j])) {
                    break;
                }
                list.get(Integer.parseInt(s[j])).add(i);
                table[i]++;
            }
        }


        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < list.size(); i++) {
            if (table[i] == 0) {
                queue.add(i);
            }
        }

        // 현재과정 이렇게 입력값을 해당 리스 형태로 만들어 준후에 선수수강 과목이 없는 1부터 queue 에 놓고 돌려본다.
        //       1번 강의를 선수로 들어야하는 커리큘럼 ->  2,3,4 연결
        //         get(1).get(2or3or4)
        //       3번 강의를 선수로 들어야하는 커리큘럼 ->  4,5 연결


        while (!queue.isEmpty()) {
            Integer poll = queue.poll(); // 인덱스 1 이들어감
            List<Integer> subList = list.get(poll); //각각의 sub list 즉 해당 poll 인덱스의 과목을 선수로 들어야하는 값들의 리스트
            for (int i = 0; i < subList.size(); i++) {
                //result[subList.get(1)] -> poll 인덱스의 서브 list중 첫번째  -> 즉 이 for문이 돌때마다 현재 poll과목을 선수학습해야하는 하는과목들의 timetable값을 갱신한다
                result[subList.get(i)] = Math.max(result[subList.get(i)], result[poll] + timeTable[subList.get(i)]);
                table[subList.get(i)]--;
                if (table[subList.get(i)] == 0) { //table 이 0 이라는것은 진입차수가 없다는 것으로 queue에 넣어야된다.
                    queue.add(subList.get(i));
                }
            }

        }


        for (int i = 1; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


}
