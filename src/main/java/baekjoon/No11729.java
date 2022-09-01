package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No11729 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        int count = Integer.parseInt(br.readLine());
        System.out.println((int) (Math.pow(2, count)) - 1);
        hanoi(count, 1, 3, 2, str);
        System.out.println(str);
    }


    public static void hanoi(int count, int start, int target, int sub, StringBuilder str) {
        if (count == 1) { //종료조건
            //1번에서 끝낼때 1번에서 sub로
            str.append(start).append(" ").append(target).append("\n");
            return;
        }
        //1번 . 3 일경우 2 , 1번에서 2번원반으로 옮기기 count가 0일경우 1번 타워의 count =1 -> 다음으로 넘어
        hanoi(count - 1, start, sub, target, str);
        //
        str.append(start).append(" ").append(target).append("\n");
        hanoi(count - 1, sub, target, start, str);
    }
}

