import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
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
