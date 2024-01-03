package baekjoon.stack;

import java.io.*;
import java.util.LinkedList;
import java.util.Stack;

public class No1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Stack<Integer> stack = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        LinkedList<Integer> datas = new LinkedList<>();
        LinkedList<String> answer = new LinkedList<>();

        for (int i = 0; i < count; i++) {
            datas.add(Integer.parseInt(br.readLine()));
        }

        int initData = 1;

        while (!datas.isEmpty()) {

            Integer targetData = datas.pollFirst();

            if (targetData > initData) {
                while (targetData != initData) {
                    stack.push(initData);
                    answer.add("+");
                    initData++;
                }
            }

            if (targetData == initData) {
                answer.add("+");
                answer.add("-");
                initData++;
                continue;
            }

            int popData = stack.pop();
            if (popData == targetData) {
                answer.add("-");
            } else {
                System.out.println("NO");
                return;
            }


        }
        while (!answer.isEmpty()) {
            bw.write(answer.pollFirst());
            bw.newLine();
        }
        bw.close();

    }
}
