package programmers.hash;

import java.util.HashMap;
import java.util.Map;

public class 위장 {
    public static void main(String[] args) {
        solution(new String[][]{
                {"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}
        });
    }


    public static int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String[] clothe : clothes) {
            String kind = clothe[1];
            if (map.containsKey(kind)) {
                map.put(kind, map.get(kind) + 1);
            } else {
                map.put(kind, 1);
            }
        }

        Object[] objects = map.values().toArray();
        for (Object object : objects) {
            answer *= (int) object + 1;
        }

        System.out.println(answer - 1);
        return answer - 1;
    }
}
