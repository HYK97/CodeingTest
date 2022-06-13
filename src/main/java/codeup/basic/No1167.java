package codeup.basic;

import java.io.*;
import java.util.Arrays;

public class No1167 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        String[] split = input.split(" ");
        int[] array = {Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])};
        int[] ints = Arrays.stream(array).sorted().toArray();
        bw.write(String.valueOf(ints[1]));
        bw.flush();
    }
}
