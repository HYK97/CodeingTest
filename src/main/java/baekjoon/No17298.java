package baekjoon;

import java.io.*;
import java.util.Stack;

public class No17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] data = new int[count];
        for (int i = 0; i < s.length; i++) {
            data[i] = Integer.parseInt(s[i]);
        }
        Stack<Integer> stack = new Stack<>();
        int[] array = new int[count];
        stack.push(0);

        for (int i = 1; i < count; i++) {
            while (!stack.isEmpty() && data[i] > data[stack.peek()]) {
                array[stack.pop()] = data[i];
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            array[stack.pop()] = -1;
        }
        for (int i = 0; i < array.length; i++) {
            bw.write(array[i] + " ");
        }
        bw.flush();

    }
}
