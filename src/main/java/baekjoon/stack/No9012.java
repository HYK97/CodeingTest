package baekjoon.stack;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Stack;

public class No9012 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No9012().solution();
	}

	@Override
	public void solution() throws IOException {
		Integer count = Integer.valueOf(br.readLine());
		for (int i = 0; i < count; i++) {
			Stack<String> stack = new Stack<>();
			String[] split = br.readLine().split("");
			for (String input : split) {
				if (!stack.isEmpty() && stack.peek().equals("(") && input.equals(")")) {
					stack.pop();
				} else {
					stack.push(input);
				}
			}
			if (stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}
