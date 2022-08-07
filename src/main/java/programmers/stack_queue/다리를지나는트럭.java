package programmers.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭 {
    public static void main(String[] args) {
        solution(2,10,new int[]{7,4,5,6});
    }

    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> start =new LinkedList<>();
        Queue<Integer> middle = new LinkedList<>();
        Queue<Integer> end = new LinkedList<>();
        for(int truckWeight : truck_weights){
            start.add(truckWeight);
        }

        int size = start.size();
        int middleWeight = 0;

        while (end.size() != size) {
            //나오는거
            if (middle.size()>=bridge_length) {
                if (middle.peek() != null) {
                    int tr = middle.poll();
                    end.add(tr);
                    middleWeight-=tr;
                } else {
                    middle.poll();
                }
            }
            //들어가는거
            if (middle.size() < bridge_length) {
                if (start.peek() != null&&middleWeight + start.peek() <= weight) {
                    int tr = start.poll();
                    middle.add(tr);
                    middleWeight += tr;
                } else {
                    middle.add(null);
                }
            }
            answer++;

        }

        System.out.println("answer = " + answer);
        return answer;
    }
}

