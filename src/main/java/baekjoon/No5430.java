package baekjoon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class No5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < testCount; i++) {
            String[] methodNames = br.readLine().split("");
            int arrayCount = Integer.parseInt(br.readLine());
            String temp = br.readLine();
            String[] data = temp.substring(1, temp.length() - 1).split(",");
            boolean zero = true;
            boolean revers = false;
            int startIndex = 0;
            int endIndex = data.length - 1;
            for (String methodName : methodNames) {
                if (methodName.equals("R")) {
                    revers = !revers;  //뒤집기
                } else {
                    if (arrayCount == 0) {
                        zero = false;
                        break;
                    }
                    if (!revers) {
                        data[startIndex] = "";
                        startIndex++;
                        arrayCount--;
                    } else {
                        data[endIndex] = "";
                        endIndex--;
                        arrayCount--;
                    }
                }
            }
            if (!zero) {
                bw.write("error\n");
            } else {
                StringBuilder bf = new StringBuilder();
                bf.append("[");
                if (!revers) {
                    for (int j = startIndex; j <= endIndex; j++) {
                        bf.append(data[j]).append(",");
                    }
                } else {
                    for (int j = endIndex; j >= startIndex; j--) {
                        bf.append(data[j]).append(",");
                    }
                }
                if (arrayCount > 0) {
                    bf.deleteCharAt(bf.length() - 1);
                }
                if (String.valueOf(bf.charAt(bf.length() - 1)).equals(",")) {
                    bf.deleteCharAt(bf.length() - 1);
                }
                bf.append("]");
                bw.write(bf.toString().strip() + "\n");
            }
        }
        bw.flush();
    }

}

