package baekjoon.deque;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class No1021 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		new No1021().solution();
	}
	@Override
	public void solution() throws IOException {
		int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = init[0];
		int M = init[1];
		int count = 0;
		int[] numberToDraw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		LinkedList<Integer> deque=new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}
		for (int i : numberToDraw) {

			int targetPosition = deque.indexOf(i);
			int size = deque.size();
			int halfIndex;
			if (size % 2 == 0) {
				halfIndex = size / 2 - 1; // 인덱스 때문에 -1 해줘야함
				// 0 1 2.5 3 4 = 2.5 는 2가됌 int라서
				// 홀수 인경우에는 size / 2 하면 가운데 인덱스인 2가 맞지만
				// 0 1 2 3
				// 이렇게 짝수인 경우에는 size /2를 하면 2가 나와버리기 때문에 -1을 해서 1~2사이로 만들어줘야함
			} else {
				halfIndex = size / 2;
			}

			if (halfIndex >= targetPosition) {
				for (int j = 0; j < targetPosition; j++) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			} else {
				for (int j = 0; j < size-targetPosition; j++) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println("count = " + count);
	}
}
