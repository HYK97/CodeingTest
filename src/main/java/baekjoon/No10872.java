package baekjoon;

import java.io.*;

public class No10872 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int data = Integer.parseInt(br.readLine());
        bw.write(String.valueOf(factorial(data)));
        bw.flush();
        br.close();
        bw.close();
    }

    public static int factorial(int data) {
        if (data <= 0) {
            return 1;
        }
        return data * factorial(data - 1);
    }
}
