package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class No2941 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        List<String> list = new ArrayList<>();
        list.add("c=");
        list.add("c-");
        list.add("dz=");
        list.add("d-");
        list.add("lj");
        list.add("nj");
        list.add("s=");
        list.add("z=");

        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            s = s.replace(list.get(i), "$");
        }
        System.out.println("count = " + s);
        count = s.length();

        /*  for (int i = 0; i < chars.length; i++) {
            if (i + 1 < chars.length && list.contains(String.valueOf(chars[i]) + String.valueOf(chars[i + 1]))) {
                i++;
            } else if (i + 2 < chars.length && list.contains(String.valueOf(chars[i]) + String.valueOf(chars[i + 1]) + String.valueOf(chars[i + 2]))) {
                i++;
                i++;
            }
            count++;
        }*/
        bw.write(String.valueOf(count));
        bw.flush();

    }

}
