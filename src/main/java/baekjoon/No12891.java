package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class No12891 {
    static Map<Character, Integer> check = new HashMap<>();
    static char[] data;
    static Map<Character, Integer> now = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        data = st.nextToken().toCharArray();
        st = new StringTokenizer(br.readLine());
        check.put('A', Integer.parseInt(st.nextToken()));
        check.put('C', Integer.parseInt(st.nextToken()));
        check.put('G', Integer.parseInt(st.nextToken()));
        check.put('T', Integer.parseInt(st.nextToken()));
        now.put('A', 0);
        now.put('C', 0);
        now.put('G', 0);
        now.put('T', 0);

        int count = 0;

        for (int i = 0; i < P; i++) {
            add(i);
        }
        if (check()) {
            count++;
        }
        for (int i = P; i < S; i++) {
            int j = i - P;
            add(i);
            remove(j);
            if (check()) {
                count++;
            }
        }

        System.out.println(count);

    }

    private static void remove(int i) {
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

    private static boolean check() {
        int flag = 0;
        for (Character data : now.keySet()) {
            if (now.get(data) >= check.get(data)) {
                flag++;
            }
        }
        if (flag == 4) {
            return true;
        } else {
            return false;
        }
    }

    private static void add(int i) {
        if (data[i] == 'A') {
            now.put('A', now.get('A') + 1);
        } else if (data[i] == 'C') {
            now.put('C', now.get('C') + 1);
        } else if (data[i] == 'G') {
            now.put('G', now.get('G') + 1);
        } else if (data[i] == 'T') {
            now.put('T', now.get('T') + 1);
        }
    }
}
