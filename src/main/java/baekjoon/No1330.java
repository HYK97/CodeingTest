package baekjoon;

import java.util.Scanner;

public class No1330 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String next = sc.nextLine();
        String result = comparator(next);
        System.out.println(result);
    }


    public static String comparator(String aAndB) {
        Integer a;
        Integer b;
        try {
            String []split = aAndB.split(" ");
            a= Integer.valueOf(split[0]);
                    b= Integer.valueOf(split[1]);
        } catch (ArrayIndexOutOfBoundsException e) {
            return "입력값 오류";
        }
        if (a > b) {
            return ">";
        } else if (a < b) {
            return "<";
        } else {
            return "==";
        }

    }



}
