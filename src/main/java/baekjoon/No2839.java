package baekjoon;

import java.io.*;

public class No2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int result = 0;
        int count = 0;
/*        if (n % 5 == 0) {
            result = n / 5;
        } else {
            while (true) {
                n -= 3;
                count++;
                if (n % 5 == 0) {
                    result = count + n / 5;
                    break;
                } else if (n <= 0) {
                    if (n == 0) {
                        result = count;
                        break;
                    } else {
                        result = -1;
                        break;
                    }
                }
            }
        }*/


        while (n >= 0) {
            if (n % 5 == 0) {    //가장 큰 수로 나누는게 가장 작은수랑 섞어서 나누는 것보다 유리
                result += (n / 5);    //나눈 몫을 더한 것이 정답
                bw.write(String.valueOf(result));
                bw.flush();
                return;
            }
            n -= 3;    //3kg을 빼고
            result++;    //가방 하나 늘어남
        }
        bw.write(String.valueOf(-1));
        bw.flush();
    }

}
