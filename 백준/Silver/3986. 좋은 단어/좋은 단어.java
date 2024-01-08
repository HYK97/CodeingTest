import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int dataCount = Integer.parseInt(br.readLine());
		int result = 0;

		for (int i = 0; i < dataCount; i++) {
			String input = br.readLine();
			if (input.length() % 2 == 1) {
				continue;
			}

			Stack<Character> stack = new Stack<>();
			for (char ch : input.toCharArray()) {
				if (!stack.isEmpty() && stack.peek() == ch) {
					stack.pop();
				} else {
					stack.push(ch);
				}
			}

			if (stack.isEmpty()) {
				result++;
			}
		}

		System.out.println(result);
	}

}
