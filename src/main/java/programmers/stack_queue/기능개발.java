package programmers.stack_queue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {

    public static void main(String[] args) {
        solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
    }

    public static int[] solution(int[] progresses, int[] speeds) {

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> speedQueue = new LinkedList<>();

        List<Integer> a = new ArrayList<>();
        for (int progress : progresses) {
            queue.add(progress);
        }
        for (int speed : speeds) {
            speedQueue.add(speed);
        }

        int day = 0;
        int count = 0;
        boolean flag = false;
        int buf = 0;
        //큐가 모두빌때까지
        while (!queue.isEmpty()) {
            // 맨첫번째 큐를 뽑아옴
            int peek = queue.peek();
            //뽑아온큐가 100이될떄까지 speed를 더함
            //동시에 날짜도 하나씩 늘림
            if (flag) {
                peek = buf;
            }
            while (peek < 100) {
                peek += speedQueue.peek();
                day++;
            }
            //만약 100이 됬다면
            //첫번째 queue 데이터를 지우고 카운트를 한개증가
            queue.remove();
            speedQueue.remove();
            count++;


            while (!queue.isEmpty()) {
                //날짜만큼 speed를 더했을 때100 보다 크면 지우고 다음 값을 계산 아니면 나옴 그리고 카운트 저장
                peek = queue.peek() + (day * speedQueue.peek());
                buf = peek;
                if (peek >= 100) {
                    queue.remove();
                    speedQueue.remove();
                    count++;
                } else {
                    break;
                }
            }
            a.add(count);
            count = 0;
            flag = true;
        }

        int[] answer = a.stream().mapToInt(i -> i).toArray();
        return answer;


    }
}
