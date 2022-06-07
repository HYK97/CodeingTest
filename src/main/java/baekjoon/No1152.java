package baekjoon;

import java.util.Scanner;

public class No1152 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String data = sc.nextLine();
        count(data);
    }
    public static void count(String sentence) {
        StringBuffer buf = new StringBuffer(sentence);

        final String FIRST_CH = buf.substring(0, 1);
        final String END_CH = buf.substring(sentence.length() - 1);


        if (FIRST_CH.equals(" ")) {
            buf.delete(0,1);
        }
        if (END_CH.equals(" ")) {
            buf.delete(sentence.length() - 1,sentence.length());
        }
        sentence = buf.toString();
        String[] result = sentence.split(" ");
        System.out.println(result.length);

    }
}
