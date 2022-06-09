package algorithm;

public class HeapSort {


    public static void main(String[] args) {
        int heap[] = {1, 7, 2, 3, 4, 5, 6};

        //처음 최대힙 구성
        for (int i = 1; i < heap.length; i++) {
            int child = i;
            do {
                int root = (child - 1) / 2;
                if (heap[root] < heap[child]) {
                    int temp = heap[root];
                    heap[root] = heap[child];
                    heap[child] = temp;
                }
                child = root;
            } while (child != 0);
        }
        // 1개씩 빼면서 최대힙 구성하기
        for (int i = heap.length - 1; i >= 0; i--) {
            //맨 마지막값을 제일 앞으로 현재 가장큰값 뒤로 보내기
            int temp = heap[0];
            heap[0] = heap[i];
            heap[i] = temp;

            for (int s : heap) {
                System.out.print(s + " ");
            }
            System.out.println();

            int root = 0;

            int c = 1;

            do {
                c = 2 * root + 1;
                // 왼쪽     오른쪽  둘중에 큰수의 인덱스 담기
                //맨뒷값은 pop해서 없는 값으로 치부해서 c가 i를 넘으면안됌.
                if (c < i - 1 && heap[c] < heap[c + 1]) {
                    c++;
                }
                //자식중 큰값과 부모와 비교
                if (c < i && heap[root] < heap[c]) {
                    int t = heap[root];
                    heap[root] = heap[c];
                    heap[c] = t;
                }
                root = c;

            } while (c < i);


        }


        for (int i : heap) {
            System.out.print(i + " ");
        }
    }

}

