package baekjoon;

import java.io.*;
import java.math.BigInteger;

public class No10757 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] AandB = br.readLine().split(" ");
        BigInteger A = new BigInteger(AandB[0]);
        BigInteger B = new BigInteger(AandB[1]);
        System.out.println(A.add(B));
    }
}