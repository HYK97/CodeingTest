

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;



/**
 * packageName :  baekjoon.dp
 * fileName : No9095
 * author :  ddh96
 * date : 2023-01-13 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-13                ddh96             최초 생성
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList<Integer> roundQue=new LinkedList<>();
        String []data  = br.readLine().split(" ");
        int numberOfPeople = Integer.parseInt(data[0]);
        int K = Integer.parseInt(data[1]);
        for (int i = 1; i <= numberOfPeople; i++) {
            roundQue.addLast(i);
        }
        String []result =new String[numberOfPeople];
        int index=0;
        int count=1;
        while (!roundQue.isEmpty()) {
            Integer e = roundQue.pollFirst();
            if (count == K) {
                String s = String.valueOf(e);
                result[index] = s;
                count=1;
                index++;
                continue;
            }
            count++;
            roundQue.addLast(e);
        }
        System.out.println("<"+String.join(", ",result)+">");

    }

}
