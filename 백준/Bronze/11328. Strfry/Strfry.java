import java.util.*;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        for (int i = 0; i < count; i++) {
            char[] alp1=new char[26];
            char[] alp2=new char[26];
            char[] original = sc.next().toCharArray();
            char[] target = sc.next().toCharArray();
            for (char c : original) {

                alp1[c-97]++;
            }
            for (char c : target) {

                alp2[c-97]++;
            }
            boolean flag =true;
            for (int j = 0; j < 26; j++) {
                if (alp1[j] != alp2[j]) {
                    System.out.println("Impossible");
                    flag=false;
                    break;
                }
            }
            if (flag) {
                System.out.println("Possible");
            }
        }
    }
}