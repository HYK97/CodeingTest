package datastructure;

import java.util.LinkedList;
import java.util.Queue;

public class QueueLearning {
    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(7);
        queue.add(5);
        queue.add(4);
        queue.poll();
        queue.add(6);
        queue.poll();
        while (!queue.isEmpty()) {
            System.out.println("queue.poll() = " + queue.poll());
        }
    }
}
