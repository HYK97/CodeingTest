import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * packageName :  baekjoon.array
 * fileName : No3273
 * author :  ddh96
 * date : 2023-11-28 
 * description : https://www.acmicpc.net/problem/3273
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-11-28                ddh96             최초 생성
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        String data = sc.nextLine();
        int targetNum= Integer.parseInt(sc.nextLine());

        int[] integerData = Arrays.stream(data.split(" ")).mapToInt(Integer::valueOf).sorted().toArray();

        int result=0;
        int head=0;
        int tail=integerData.length-1;

        while(head < tail){
            int sum = integerData[head]+integerData[tail];
            if(sum==targetNum){
                result++;
                head++;
                tail--;
            }else if(sum>targetNum){
                tail--;
            }else{
                head++;
            }
        }

        System.out.println(result);
    }
}
