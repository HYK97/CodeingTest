package datastructure;

public class LinkedList {
    private Node head;


    public LinkedList() {
        head = new Node();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(1);
        list.add(5);
        list.add(2);
        list.add(2);
        list.add(2);
        list.duplicateRemove();
        list.print();
        list.recursionFindNthValue(1, list.head);
    }

    public void add(int data) {
        Node list = new Node(data); //추가할 node
        Node now = head; // 현재 node
        while (now.getNext() != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            now = now.getNext();
        }
        now.setNext(list);
    }

    public void delete(int data) {
        Node now = head;// 헤더다음 첫번째값.
        //다음값이 널일떄까지 반복문
        while (now.getNext() != null) {
            //다음값은 데이터가 매개변수 data 와 같으면
            if (now.getNext().getData() == data) {
                //2    에 다음3 에다가  2의 다음 3 다음 4를 넣는다.
                now.setNext(now.getNext().getNext());
            } else {
                now = now.getNext();
            }
        }
    }


    public void print() {
        Node now = head.getNext();
        while (now.getNext() != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            System.out.println(now.getData() + " ");
            now = now.getNext();
        }
        System.out.println(now.getData() + " ");
    }


    /**
     * 중복값 제거
     */
    void duplicateRemove() {
        Node now = head;
        while (now != null && now.getNext() != null) {
            Node runner = now;
            while (runner.getNext() != null) {
                if (now.getData() == runner.getNext().getData()) {
                    runner.setNext(runner.getNext().getNext());
                } else {
                    runner = runner.getNext();
                }
            }
            now = now.getNext();
        }
    }


    /*특정노드 찾기 재귀이용*/
    int recursionFindNthValue(int n, Node node) {
        if (node == null) {
            return 0;
        }
        int count = recursionFindNthValue(n, node.getNext()) + 1;
        if (count == n) {
            System.out.println(n + "번째 값은 = " + node.getData());

        }

        return count;
    }

}
