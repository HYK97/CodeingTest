package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class No2588 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int first = Integer.parseInt(br.readLine());
        String second = br.readLine();
        char[] secondArray = second.toCharArray();
        for (int i = secondArray.length - 1; i >= 0; i--) {
            System.out.println((secondArray[i] - '0') * first);
        }
        System.out.println(Integer.parseInt(second) * first);
        br.close();

    }
}
