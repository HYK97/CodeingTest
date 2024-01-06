
import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {



	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int commandCount = Integer.parseInt(br.readLine());
		Deque<Integer> queue = new LinkedList<>();
		for (int i = 0; i < commandCount; i++) {
			String[] split = br.readLine().split(" ");
			String command = split[0];

			if (split.length == 2 && command.equals("push")) {
				int data = Integer.parseInt(split[1]);
				queue.add(data);
				continue;
			}
			if (command.equals("pop")) {
				if (extracted(queue, bw)) continue;
				bw.write(String.valueOf(queue.pollFirst()));
				bw.newLine();
				continue;
			}
			if (command.equals("size")) {
				bw.write(String.valueOf(queue.size()));
				bw.newLine();
				continue;
			}
			if (command.equals("empty")) {
				bw.write(queue.isEmpty() ? "1" : "0");
				bw.newLine();
				continue;
			}
			if (command.equals("front")) {
				if (extracted(queue, bw)) continue;
				bw.write(String.valueOf(queue.peekFirst()));
				bw.newLine();
				continue;
			}
			if (command.equals("back")) {
				if (extracted(queue, bw)) continue;
				bw.write(String.valueOf(queue.peekLast()));
				bw.newLine();
			}

		}
		bw.close();
	}

	private static boolean extracted(Deque<Integer> queue, BufferedWriter bw) throws IOException {
		if (queue.isEmpty()) {
			bw.write("-1");
			bw.newLine();
			return true;
		}
		return false;
	}

}
