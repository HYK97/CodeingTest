package codeup.basic;

import java.io.*;
import java.util.Stack;

public class No1094 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        String[] split = br.readLine().split(" ");
        for (int i = 0; i < number; i++) {
            stack.push(Integer.valueOf(split[i]));
        }
        for (int i = 0; i < number; i++) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
    }
}
