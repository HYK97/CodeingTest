package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class No2750 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int i = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int j = 0; j < i; j++) {
            list.add(sc.nextInt());
        }
        List<Integer> collect = list.parallelStream().sorted().collect(Collectors.toList());
        for (Integer integer : collect) {
            System.out.println(integer);
        }
    }
}
