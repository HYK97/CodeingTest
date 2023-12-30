import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();

        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            int data = Integer.parseInt(br.readLine());
            if (data==0 && !stack.isEmpty()) {
                stack.pop();
                continue;
            }
            stack.push(data);
        }
        int sum = 0;
        while(!stack.isEmpty()) {
            sum += stack.pop();
        }
        System.out.println(sum);
    }
}