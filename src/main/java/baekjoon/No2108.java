package baekjoon;

import java.io.*;

public class No2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int index = Integer.parseInt(br.readLine());
        int[] count = new int[8001];
        int sum = 0;
        int maxbin = 0;
        int maxData = -4001;
        int minData = 4001;
        boolean flag = true;
        int flagint = 0;
        for (int i = 0; i < index; i++) {
            int input = Integer.parseInt(br.readLine());
            sum += input;
            count[4000 + input]++;
            if (maxbin < count[4000 + input]) {
                maxbin = count[4000 + input];
            }
            if (maxData < input) {
                maxData = input;
            }
            if (minData > input) {
                minData = input;
            }
        }
        //평균
        int avg = (int) Math.round((double) sum / index);

        //중앙값
        int mid = 0;
        int c = 0;
        for (int i = 0; i < 8001; i++) {
            if (count[i] != 0) {
                c += count[i];
                if (c > (int) Math.ceil(index / 2)) {
                    mid = i - 4000;
                    break;
                }
            }
        }

        int bin = 0;

        for (int i = 0; i < 8001; i++) {
            if (count[i] == maxbin) {
                flagint++;
            }
        }
        if (flagint == 1) {
            for (int i = 0; i < 8001; i++) {
                if (count[i] == maxbin) {
                    bin = i - 4000;
                    break;
                }
            }
        } else {
            for (int i = 0; i < 8001; i++) {
                if (count[i] == maxbin) {
                    if (!flag) {
                        bin = i - 4000;
                        break;
                    } else {
                        flag = false;
                    }
                }
            }
        }


        int range = maxData - minData;
        bw.write(String.valueOf(avg) + "\n");
        bw.write(String.valueOf(mid) + "\n");
        bw.write(String.valueOf(bin) + "\n");
        bw.write(String.valueOf(range) + "\n");
        bw.flush();


    }


}
