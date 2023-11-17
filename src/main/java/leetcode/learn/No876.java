package leetcode.learn;

import java.util.ArrayList;
import java.util.List;


/*
* https://leetcode.com/problems/middle-of-the-linked-list/
* */
public class No876 {

    //방법 1
    public ListNode sol1(ListNode head) {
        int size=1;
        ListNode currentNode=head;

        while (currentNode.next != null) { //순회
            size++;
            currentNode = currentNode.next;
        }

        if (size == 1) {
            return currentNode;
        }

        currentNode=head;

        int count=1;

        while (Math.ceil((double) size / 2) != count) {
            count++;
            currentNode = currentNode.next;
        }

        if (size % 2 == 0) {
           return currentNode.next;
        }

        return currentNode;
    }

    //방법2
    public ListNode sol2(ListNode head) {
        int size=1;
        List<ListNode> cache = new ArrayList<>();
        cache.add(head);
        while (head.next != null) {
            size++;
            ListNode nextNode = head.next;
            head = nextNode;
            cache.add(nextNode);
        }
        return cache.get(size/2);
    }

    static class ListNode {
        int val; //1~100
        int size;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}