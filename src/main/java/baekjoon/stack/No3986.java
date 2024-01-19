package baekjoon.stack;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Stack;

public class No3986 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No3986().solution();
	}

	@Override
	public void solution() throws IOException {
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
