package baekjoon;

import java.io.*;

public class No10870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int data = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(fibonacci(data)));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int fibonacci(int data) {
        if (data == 0) {
            return 0;
        } else if (data < 3) {
            return 1;
        } else {
            return fibonacci(data - 1) + fibonacci(data - 2);
        }
    }
}
