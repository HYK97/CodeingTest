package baekjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class No1431 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = sc.nextInt();
        sc.nextLine();
        List<String> heap = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            heap.add(sc.nextLine());
        }
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length()) {
                    return 1;
                } else if (o1.length() < o2.length()) {
                    return -1;
                } else {
                    int sum1 = sum(o1);
                    int sum2 = sum(o2);
                    if (sum1 < sum2) {
                        return -1;
                    } else if (sum1 > sum2) {
                        return 1;
                    } else {
                        return o1.compareTo(o2);
                    }
                }
            }
        };

        Collections.sort(heap, comparator);
        for (int i = 0; i < heap.size(); i++) {

            if (i < heap.size() - 1 && heap.get(i).equals(heap.get(i + 1))) {
                continue;
            } else {
                if (i < heap.size() - 1) {
                    bw.write(heap.get(i) + "\n");
                } else {
                    bw.write(heap.get(i));
                }
            }


        }
        bw.flush();
    }

    public static int sum(String n) {
        int result = 0;
        for (int i = 0; i < n.length(); i++) {
            if (0 <= n.charAt(i) - '0' && n.charAt(i) - '0' <= 9) {
                result += n.charAt(i) - '0';
            }
        }
        return result;

    }


}
