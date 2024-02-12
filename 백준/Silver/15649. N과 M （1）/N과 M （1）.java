
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int N;
    static int M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static List<Integer> result = new ArrayList<>();
    static boolean[] check;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String[] NandM = br.readLine().split(" ");
        N = Integer.parseInt(NandM[0]);
        M = Integer.parseInt(NandM[1]);
        check = new boolean[N + 1];
        recursion(0);
        bw.flush();

    }

    public static void recursion(int number) throws IOException {
        if (number == M) {
            for (int i : result) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (!check[i]) {
                check[i] = true;
                result.add(i);
                recursion(number + 1);
                check[i] = false;
                result.remove(result.size() - 1);
            }
        }
    }

}

