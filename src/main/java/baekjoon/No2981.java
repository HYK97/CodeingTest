package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2981 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputCount = Integer.parseInt(br.readLine());
        int[] data = new int[inputCount];
        for (int i = 0; i < inputCount; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }

        int temp = Math.abs(data[0] - data[1]);
        for (int i = 2; i < inputCount; i++) {


            int temp2 = Math.abs(data[i] - data[i - 1]);
            temp = GCD(temp, temp2);

        }


        for (int i = 2; i <= temp; i++) {
            if (temp % i == 0) {
                System.out.print(i + " ");
            }
        }

    }

    public static int GCD(int a, int b) {


        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;


    }


}
