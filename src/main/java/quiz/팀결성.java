package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * packageName :  quiz
 * fileName : 팀결성
 * author :  ddh96
 * date : 2022-11-15
 * description : 서로소 집합 알고리즘 이용
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-11-15                ddh96             최초 생성
 */
public class 팀결성 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);// 팀개수
        int M = Integer.parseInt(s[1]);// 연산개수
        int[] table = new int[N + 1];
        for (int i = 0; i < table.length; i++) {
            table[i] = i;
        }
        for (int i = 0; i < M; i++) {
            String[] s1 = br.readLine().split(" ");
            int op = Integer.parseInt(s1[0]);
            int a = Integer.parseInt(s1[1]);
            int b = Integer.parseInt(s1[2]);

            if (op == 1) { // 연산이 팀여부 확인일경우  a 와 b 가 같은 팀인지 확인
                String result = findParent(a, table) == findParent(b, table) ? "yes" : "no";
                System.out.println("result = " + result);
            } else { // 팀 합치기 연산일 경우에는 더작은 부모집합 팀으로 합침
                union(a, b, table);
            }
        }
    }

    public static void union(int a, int b, int[] table) {
        int parentA = findParent(a, table);
        int parentB = findParent(b, table);
        if (table[parentA] > table[parentB]) {
            table[parentA] = table[parentB];
        } else {
            table[parentB] = table[parentA];
        }
    }

    public static int findParent(int a, int[] table) {
        if (a != table[a]) {
            return findParent(table[a], table);
        }
        return a;
    }

}
