import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] data = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        int i = 1;
        int j = 1;
        int count = N * 2;
        do {
            if (stack.isEmpty()) {
                sb.append("+\n");
                stack.push(i);
                i++;
                count--;
            }
            if (stack.peek() == data[j]) {
                data[j] = 0;
                stack.pop();
                sb.append("-\n");
                j++;
                count--;
            } else {
                sb.append("+\n");
                stack.push(i);
                i++;
                count--;
            }
        }
        while (count != 0);
        int flag = 0;
        for (int datum : data) {
            if (datum != 0) flag = 1;
        }
        if (flag == 0) {
            System.out.println(sb);
        } else {
            sb.setLength(0);
            sb.append("NO");
            System.out.println(sb);
        }
    }


}
