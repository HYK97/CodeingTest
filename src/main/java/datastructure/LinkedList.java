package datastructure;

import java.util.HashSet;

public class LinkedList<T> {
    private Node<T> head;

    public LinkedList() {

    }

    /*  public static void main(String[] args) {
          LinkedList list = new LinkedList();
          list.add(7);
          list.add(2);
          list.add(8);
          list.add(5);
          list.add(3);
          list.add(4);

          list.duplicateRemove();
          list.print();
          list.recursionFindNthValue(1, list.head);
          //Node node = list.nodeNSorted(list.head.getNext(), 5);
          Node node = list.nodeNSortedHeadAndTail(list.head.getNext(), 3);
          while (node.getNext() != null) {
              System.out.print(node.getData() + " ");
              node = node.getNext();
          }
          System.out.print(node.getData() + " ");

      }
  */
    public static <T> boolean checkPalindrome(LinkedList<T> list) {
        Node<T> current = list.head;
        Node<T> left = list.head;
        Node<T> right = null;

        int count = 0;
        while (current != null) {
            right = current;
            current = current.getNext();
            count++;
        }

        Node<T> prevRight = right;
        for (int i = 0; i < count / 2; i++) {
            if (!right.getData().equals(left.getData())) {
                return false;
            }
            left = left.getNext();
            right = left;
            while (right.getNext() != prevRight) {
                right = right.getNext();
            }
        }
        return true;
    }

    public static void dataCollect(String[] data) {
        //given
        HashSet<Character> set = new HashSet<>();
        for (String s : data) {
            char c = s.toCharArray()[0];
            set.add(c);
        }

        Character[] chars = set.toArray(new Character[0]);
        LinkedList<String>[] lists = new LinkedList[set.size()];
        for (int i = 0; i < chars.length; i++) {
            lists[i] = new LinkedList<>();
            lists[i].add(chars[i].toString());
        }

        //when
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < lists.length; j++) {
                if (lists[j].head.getData().equals(data[i].split("")[0])) {
                    lists[j].add(data[i]);
                }
            }
        }

        for (LinkedList<String> list : lists) {
            list.print();
            System.out.println();
        }

        //then

    }

    public void add(T data) {
        Node<T> newNode = new Node<T>(data); //추가할 node
        if (this.head == null) {
            head = newNode;
            return;
        }
        Node<T> head = this.head; // 현재 node
        while (head.getNext() != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            head = head.getNext();
        }
        head.setNext(newNode);
    }

    public void delete(T data) {
        Node<T> now = head;// 헤더다음 첫번째값.
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
        Node<T> now = head;
        while (now.getNext() != null) { // 현재 node가 null일때 그뒤에 붙이도록함
            System.out.print(now.getData() + " ");
            now = now.getNext();
        }
        System.out.print(now.getData() + " ");
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
    int recursionFindNthValue(int n, Node<T> node) {
        if (node == null) {
            return 0;
        }
        int count = recursionFindNthValue(n, node.getNext()) + 1;
        if (count == n) {
            System.out.println(n + "번째 값은 = " + node.getData());

        }

        return count;
    }

    /*m노드 기준으로 오른쪽 왼쪽 정렬
     * 나눠서 합치기
     * *//*
    Node nodeNSorted(Node start, int n) {

        Node leftStart = null;
        Node leftEnd = null;
        Node rightStart = null;
        Node rightEnd = null;
        while (start != null) {
            //분리
            Node next = start.getNext(); //다음노드를 미리 받아놓고
            start.setNext(null);// 현재 노드 다음 노드를 널로 만들어서 분리함
            //분리
            if (start.getData() >= n) {
                if (rightStart == null) {
                    rightStart = start;
                    rightEnd = rightStart;
                } else {
                    rightEnd.setNext(start); // 현재포인터의 다음 값을 지정
                    rightEnd = start; // 현재 값에 다음 포인터 지정
                }

            } else {
                if (leftStart == null) {
                    leftStart = start;
                    leftEnd = leftStart;
                } else {
                    leftEnd.setNext(start);
                    leftEnd = start;
                }
            }
            start = next; // 처음에 분리했던 노드를 첫노드로 만듦

        }
        if (leftStart == null) {
            return rightStart;
        }
        leftEnd.setNext(rightStart);
        return leftStart;

    }

    *//*
     * 헤드와 꼬리로 나누기
     * *//*
    Node nodeNSortedHeadAndTail(Node start, int n) {
        Node head = start;
        Node tail = start;
        while (start != null) {
            Node next = start.getNext();
            start.setNext(null);
            if (start.getData() >= n) {
                tail.setNext(start);//현재가리키고있는 포인터의 다음게체를  붙이는것이 값을넣는것과같음.
                tail = start; // 포인터 옮기는것
            } else {
                start.setNext(head);
                head = start;
            }
            start = next;
        }
        tail.setNext(null); //마지막임을 알림
        return head;
    }*/

}
