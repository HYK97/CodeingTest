

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();
        int[] alp1 = new int[26];
        int[] alp2 = new int[26];
        for (char c : first) {
            alp1[c - 97]++;
        }
        for (char c : second) {
            alp2[c - 97]++;
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            int one = alp1[i];
            int two = alp2[i];
            if (one != two) {
                result += Math.abs(one - two);
            }
        }
        System.out.println(result);
    }
}
