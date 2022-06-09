package library;

import java.util.Collections;
import java.util.PriorityQueue;

public class HeapLib {
    public static void main(String[] args) {

        /**
         * 오름차순
         * */
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        pQueue.add(10);
        pQueue.add(4);
        pQueue.add(5);
        pQueue.add(2);
        System.out.println("오름차순");
        while (!pQueue.isEmpty()) {
            System.out.print(pQueue.poll() + " ");
        }
        System.out.println();
        /**
         * 내림차순
         * */
        PriorityQueue<Integer> pQueueReverse = new PriorityQueue<>(Collections.reverseOrder());
        pQueueReverse.add(10);
        pQueueReverse.add(4);
        pQueueReverse.add(5);
        pQueueReverse.add(2);
        System.out.println("내림차순");
        while (!pQueueReverse.isEmpty()) {
            System.out.print(pQueueReverse.poll() + " ");
        }


    }
}
