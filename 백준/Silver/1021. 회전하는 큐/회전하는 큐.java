import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Main {

	public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws IOException {
		int[] init = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		int N = init[0];
		int M = init[1];
		int count = 0;
		int[] numberToDraw = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		LinkedList<Integer> deque = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			deque.addLast(i);
		}
		for (int i : numberToDraw) {

			int targetPosition = deque.indexOf(i);
			int size = deque.size();
			int halfIndex;
			if (size % 2 == 0) {
				halfIndex = size / 2 - 1;
			} else {
				halfIndex = size / 2;
			}

			if (halfIndex >= targetPosition) {
				for (int j = 0; j < targetPosition; j++) {
					deque.addLast(deque.pollFirst());
					count++;
				}
			} else {
				for (int j = 0; j < size - targetPosition; j++) {
					deque.addFirst(deque.pollLast());
					count++;
				}
			}
			deque.pollFirst();
		}
		System.out.println(count);
	}

}