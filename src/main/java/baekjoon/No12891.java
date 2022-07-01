package baekjoon;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No12891 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        char[] data = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        Map<Character, Integer> check = new HashMap<>();
        check.put('A', Integer.parseInt(st.nextToken()));
        check.put('C', Integer.parseInt(st.nextToken()));
        check.put('G', Integer.parseInt(st.nextToken()));
        check.put('T', Integer.parseInt(st.nextToken()));
        Map<Character, Integer> now = new HashMap<>();
        now.put('A', 0);
        now.put('C', 0);
        now.put('G', 0);
        now.put('T', 0);
        int count = 0;

        for (int i = 0; i < P; i++) {
            add(i, data, now);
        }
        if (check(check, now)) {
            count++;
        }
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(i, data, now);
            remove(data, now, j);
            if (check(check, now)) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static void remove(char[] data, Map<Character, Integer> now, int i) {
        if (data[i] == 'A') {
            now.put('A', now.get('A') - 1);
        } else if (data[i] == 'C') {
            now.put('C', now.get('C') - 1);
        } else if (data[i] == 'G') {
            now.put('G', now.get('G') - 1);
        } else if (data[i] == 'T') {
            now.put('T', now.get('T') - 1);
        }
    }

    private static boolean check(Map<Character, Integer> check, Map<Character, Integer> now) {
        int flag = 0;
        for (Character data : now.keySet()) {
            if (now.get(data) > 0) {
                flag++;
            }
        }
        if (check.equals(now) || flag == 0) {
            return true;
        } else {
            return false;
        }


    }

    private static void add(int P, char[] data, Map<Character, Integer> now) {
        if (data[P] == 'A') {
            now.put('A', now.get('A') + 1);
        } else if (data[P] == 'C') {
            now.put('C', now.get('C') + 1);
        } else if (data[P] == 'G') {
            now.put('G', now.get('G') + 1);
        } else if (data[P] == 'T') {
            now.put('T', now.get('T') + 1);
        }
    }
}
