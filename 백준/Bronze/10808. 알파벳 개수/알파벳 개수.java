import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] alpha = new int[26];
        Arrays.fill(alpha, 0);
        String s = sc.nextLine();
        char[] charArray = s.toCharArray();
        for (char ch : charArray) {
            alpha[ch - 97]++;
        }
        for (int i : alpha) {
            System.out.print(i + " ");
        }
    }
}