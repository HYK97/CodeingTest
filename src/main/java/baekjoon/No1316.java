package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class No1316 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            String next = sc.next();
            inputs.add(next);
        }
        inputs.parallelStream().filter(i->{

        })

    }
}
