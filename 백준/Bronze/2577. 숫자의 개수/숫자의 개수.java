

import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int result = A*B*C;
        int [] count=new int[10];
        String[] intToStringArray = String.valueOf(result).split("");
        for (String s : intToStringArray) {
            count[Integer.parseInt(s)]++;
        }
        for (int i : count) {
            System.out.println(i);
        }
    }
}