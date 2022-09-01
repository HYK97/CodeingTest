package baekjoon;

import java.io.*;

public class No9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int length = getScan(br);
        int[] data = new int[length];
        int[] prime = getPrime();
        for (int i = 0; i < length; i++) {
            data[i] = getScan(br);
            int a = data[i] / 2;
            int b = data[i] / 2;
            while (true) {
                if (prime[a] == 0 && prime[b] == 0) {
                    bw.write(a + " " + b + "\n");
                    break;
                } else {
                    a--;
                    b++;
                }
            }
        }
        bw.flush();
    }

    private static int getScan(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }


    private static int[] getPrime() {
        int[] prime = new int[10000];
        for (int j = 2; j < 10000; j++) {
            if (prime[j] == 0) {
                for (int k = 2; k * j < 10000; k++) {
                    prime[k * j] = 1;
                }
            }
        }
        return prime;
    }

}

