package baekjoon;

import java.io.*;

public class No11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] split = br.readLine().split(" ");
        String[] data = br.readLine().split(" ");
        int result = 0;
        int[] sumArray = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            if (i == 0) {
                sumArray[0] = Integer.parseInt(data[0]);
            } else {
                sumArray[i] = Integer.parseInt(data[i]) + sumArray[i - 1];
            }
        }
        for (int i = 0; i < Integer.parseInt(split[1]); i++) {
            String[] range = br.readLine().split(" ");
            int iindex = Integer.parseInt(range[0]) - 1;
            int jindex = Integer.parseInt(range[1]) - 1;
            if (iindex == 0) {
                result = sumArray[jindex];
            } else {
                result = sumArray[jindex] - sumArray[iindex - 1];
            }
            bw.write(result + "\n");
        }
        bw.flush();
    }
}
