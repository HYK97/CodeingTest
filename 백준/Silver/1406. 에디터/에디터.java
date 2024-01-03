import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedList<String> init = new LinkedList<>(Arrays.asList(br.readLine().split("")));
        LinkedList<String> buffer = new LinkedList<>();

        int numberOfCommands = Integer.parseInt(br.readLine());
        for (int i = 0; i < numberOfCommands; i++) {
            String command = br.readLine();
            if (command.equals("L") && !init.isEmpty()) {
                buffer.addFirst(init.pollLast());
                continue;
            }
            if (command.equals("D") && !buffer.isEmpty()) {
                init.addLast(buffer.pollFirst());
                continue;
            }
            if (command.equals("B") && !init.isEmpty()) {
                init.removeLast();
                continue;
            }
            String[] pCommand = command.split(" ");
            if (pCommand.length == 2) {
                String addData = pCommand[1];
                init.addLast(addData);
            }
        }
        for (String s : init) {
            bw.write(s);
        }
        for (String s : buffer) {
            bw.write(s);
        }
        bw.newLine();
        bw.close();
    }
}