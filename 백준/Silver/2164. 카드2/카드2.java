import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int totalCardNum = Integer.parseInt(br.readLine());
		Deque<Integer> cards = new LinkedList<>();

		for (int i = 1; i <= totalCardNum; i++) {
			cards.add(i);
		}
		boolean isPop = false;
		while (cards.size() != 1) {
			if (!isPop) {
				cards.pollFirst(); //6
				isPop = true;
				continue;
			}
			cards.addLast(cards.pollFirst());
			isPop = false;
		}
		System.out.println(cards.pollFirst());

	}
}
