package leetcode.sort;

import leetcode.learn.No876;

import java.util.*;

/**
 * https://leetcode.com/problems/sort-list/description/
 */
public class No148 {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        ListNode current = head;
        while (current != null) {
            pq.offer(current.val);
            //heap에 value를 넣는다.
            current = current.next;
        }

        ListNode dummy = new ListNode();
        ListNode result = dummy; //head 첫번째 가르키는용
        while (!pq.isEmpty()) {
            //heap에서 작은 순서대로 뽑아서 새로운 ListNode를 만들어주고
            //첫번째는 비어있는 node -> 첫번째일때 dummy.next는 head를 가르킴
            dummy.next = new ListNode(pq.poll());
            //dummy에 현재 노드 설정 첫번째일경우 1
            dummy = dummy.next;
        }

        return result.next;

    }

    public static void main(String[] args) {
        No148 solution = new No148();
        ListNode tail =new ListNode(3,null);
        ListNode three =new ListNode(1,tail);
        ListNode two =new ListNode(2,three);
        ListNode one =new ListNode(4,two);

        ListNode listNode = solution.sortList(one);
        while (listNode != null) {
            System.out.println("listNode = " + listNode.val);
            listNode = listNode.next;
        }

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}