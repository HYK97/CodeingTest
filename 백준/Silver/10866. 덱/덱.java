import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

	private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {


		int commandCount = Integer.parseInt(br.readLine());
		Deque<String> deque = new LinkedList<>();
		for (int i = 0; i < commandCount; i++) {
			String[] split = br.readLine().split(" ");
			String command = split[0];
			if (split.length == 2) {
				String inputData = split[1];
				if (command.equals("push_back")) {
					deque.addLast(inputData);
					continue;
				}
				if (command.equals("push_front")) {
					deque.addFirst(inputData);
				}
			}
			if (command.equals("pop_front")) {
				if (isEmpty(deque)) {
					continue;
				}
				bw.write(deque.pollFirst());
				bw.newLine();
				continue;
			}
			if (command.equals("pop_back")) {
				if (isEmpty(deque)) {
					continue;
				}
				bw.write(deque.pollLast());
				bw.newLine();
				continue;
			}
			if (command.equals("size")) {
				bw.write(String.valueOf(deque.size()));
				bw.newLine();
				continue;
			}
			if (command.equals("empty")) {
				bw.write(deque.isEmpty() ? "1" : "0");
				bw.newLine();
				continue;
			}
			if (command.equals("front")) {
				if (isEmpty(deque)) {
					continue;
				}
				bw.write(deque.peekFirst());
				bw.newLine();
				continue;
			}
			if (command.equals("back")) {
				if (isEmpty(deque)) {
					continue;
				}
				bw.write(deque.peekLast());
				bw.newLine();
			}
		}
		bw.close();
	}

	private static boolean isEmpty(Deque<String> deque) throws IOException {
		if (deque.isEmpty()) {
			bw.write("-1");
			bw.newLine();
			return true;
		}
		return false;
	}
}

