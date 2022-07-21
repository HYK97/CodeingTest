package quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Palindrome {

    public static void main(String[] args) {


        long start = System.currentTimeMillis();
        String k = "d".repeat(5);
        solution1(k);
        long end = System.currentTimeMillis();
        System.out.println(end - start);

        // 속도차이는 값이 커질수록 기하급수 적으로 난다.

        k = "d".repeat(5);
        long start2 = System.currentTimeMillis();
        solution2(k);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);


    }

    //이해도어려움
    public static void solution1(String data) {
        if (data.length() < 2) {
            System.out.println(false);
            return;
        }
        char[] chars = data.toCharArray();
        int count = chars.length / 2;

        List<Character> one = new ArrayList<>();
        List<Character> two = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            one.add(chars[i]);
        }
        for (int i = chars.length - 1; i > (data.length() % 2 == 0 ? count - 1 : count); i--) {
            two.add(chars[i]);
        }
        System.out.println(Arrays.equals(one.toArray(), two.toArray()));
    }

    public static void solution2(String data) {
        if (data.length() < 2) {
            System.out.println(false);
            return;
        }
        char[] chars = data.toCharArray();
        int length = chars.length - 1;
        int count = length / 2;


        for (int i = 0; i < count; i++) {
            if (chars[i] != chars[length - i]) {
                System.out.println(false);
                return;
            }
        }
        System.out.println("true");


    }
}
