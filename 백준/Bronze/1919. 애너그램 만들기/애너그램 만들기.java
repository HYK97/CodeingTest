import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        LinkedHashMap<Character, Integer> firstMap = new LinkedHashMap<>();
        LinkedHashMap<Character, Integer> secondMap = new LinkedHashMap<>();
        char[] first = br.readLine().toCharArray();
        char[] second = br.readLine().toCharArray();

        for (char c = 'a'; c <= 'z'; c++) {
            firstMap.put(c, 0);
            secondMap.put(c, 0);
        }

        for (char c : first) {
            firstMap.put(c, firstMap.get(c) + 1);
        }
        for (char c : second) {
            secondMap.put(c, secondMap.get(c) + 1);
        }
        int result=0;
        for (Character c : firstMap.keySet()) {
            Integer firstData = firstMap.get(c);
            Integer secondData = secondMap.get(c);
            if (!firstData.equals(secondData)) {
                result+=Math.abs(firstData-secondData);
            }
        }
        System.out.println(result);
    }
}
