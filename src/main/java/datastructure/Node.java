package datastructure;

public class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node() {
    }

    public static void main(String[] args) {
        Node list = new Node(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.delete(4);
        list.print();
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void add(int data) {
        Node list = new Node(data); //추가할 node
        Node now = this; // 현재 node
        while (now.next != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            now = now.next;
        }
        now.next = list;
    }

    public void delete(int data) {
        Node now = this;
        // now 는 1    2->  다음이 널이 아니면  2->다음 데이터를 비교 ->
        while (now.next != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            if (now.next.data == data) {
                now.next = now.next.next;
            } else {
                now = now.next;
            }
        }
    }


    public void print() {
        Node now = this;
        while (now.next != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            System.out.println(now.data + " ");
            now = now.next;
        }
        System.out.println(now.data + " ");
    }

}
