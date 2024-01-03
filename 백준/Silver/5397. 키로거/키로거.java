import java.io.*;
import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String[] commands = br.readLine().split("");
            LinkedList<String> head = new LinkedList<>();
            LinkedList<String> tail = new LinkedList<>();
            for (String command : commands) {
                if (command.equals("<")) {
                    if (head.isEmpty()) {
                        continue;
                    }
                    tail.addFirst(head.pollLast());
                    continue;
                }
                if (command.equals(">")) {
                    if (tail.isEmpty()) {
                        continue;
                    }
                    head.addLast(tail.pollFirst());
                    continue;
                }
                if (command.equals("-")) {
                    if (head.isEmpty()) {
                        continue;
                    }
                    head.removeLast();
                    continue;
                }
                head.addLast(command);
            }
            for (String s : head) {
                bw.write(s);
            }
            for (String s : tail) {
                bw.write(s);
            }
            bw.newLine();
        }
        bw.close();

    }
}
