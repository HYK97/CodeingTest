package baekjoon.stack;

import java.io.*;
import java.util.Stack;

public class No10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        Stack<String> stack =new Stack<>();
        for (int i = 0; i < count; i++) {
            String [] split = br.readLine().split(" ");
            String command = split[0];

            if (split.length == 2) {
                String value = split[1];
                stack.push(value);
                continue;
            }
            if (command.equals("pop")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(stack.pop()+"\n");
                continue;
            }
            if (command.equals("size")) {
                bw.write(stack.size()+"\n");
                continue;
            }
            if (command.equals("empty")) {
                bw.write(stack.isEmpty()?"1\n":"0\n");
                continue;
            }
            if (command.equals("top")) {
                if (stack.isEmpty()) {
                    bw.write("-1\n");
                    continue;
                }
                bw.write(stack.peek()+"\n");
            }
        }
        bw.close();
    }
}