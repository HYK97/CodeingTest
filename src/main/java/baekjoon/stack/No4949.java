package baekjoon.stack;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Stack;

public class No4949 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No4949().solution();
	}

	@Override
	public void solution() throws IOException {
		Stack<String> leftStack =new Stack<>();
		Stack<String> rightStack =new Stack<>();
		String lines = br.readLine();
		while (!lines.equals(".")) {
			String[] line = lines.split("");
			for (String ch : line) {
				if (ch.equals("[") || ch.equals("]") || ch.equals("(") || ch.equals(")")) {
					leftStack.push(ch);
				}
			}
			while (!leftStack.isEmpty()){
				String data = leftStack.peek();
				if (!rightStack.isEmpty() && data.equals("[") && rightStack.peek().equals("]")) {
					leftStack.pop();
					rightStack.pop();
					continue;
				}
				if (!rightStack.isEmpty() && data.equals("(") && rightStack.peek().equals(")")) {
					leftStack.pop();
					rightStack.pop();
					continue;
				}
				rightStack.push(leftStack.pop());
			}

			if (leftStack.isEmpty() && rightStack.isEmpty()) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}

			leftStack.clear();
			rightStack.clear();
			lines = br.readLine();
		}
	}
}