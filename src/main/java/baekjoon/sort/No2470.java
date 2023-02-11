package baekjoon.sort;

import java.util.Arrays;
import java.util.Scanner;

public class No2470 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = sc.nextInt();
        sc.nextLine();
        int[] data = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
        int start = 0;
        int end = data.length - 1;
        int prevGap = Integer.MAX_VALUE;
        int data1 = 0;
        int data2 = 0;

        while (start < end) {
            int currentGap = data[start] + data[end];
            int absGap = Math.abs(currentGap); // 절대값으로 0에 가까운 것을 판단

            if (absGap == 0) { //0 이면 가장 작은 경우므로 리턴
                data1 = data[start];
                data2 = data[end];
                break;
            }

            if (prevGap > absGap) { // 이전 값보다 0에 가까울 경우 gap 업데이트
                prevGap = absGap;
                data1 = data[start];
                data2 = data[end];
            }

            if (currentGap < 0) { // gap 이 음수 인경우는 음수 값을 증가 시켜줘야  0으로 가까워 지기때문에 start 포인터를 ++
                start++;
                continue;
            }

            if (currentGap > 0) { // gap 이 양수인 경우에는  양수 값을 감소 시켜야 0으로 가까워 지기때문에 end 포인터를 --
                end--;
            }
        }
        System.out.println(data1 + " " + data2);
    }

}

