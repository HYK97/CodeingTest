package programmers.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class 귤고르기 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> m = new HashMap<>();
        for (int t : tangerine) {
            m.put(t, m.getOrDefault(t, 0) + 1);
        }
        List<Integer> list = new ArrayList<>(m.values());
        list.sort(Collections.reverseOrder());

        int sizeType = 0; // 사이즈 개수
        int count = 0; //선택한 귤의 개수
        for (Integer tangerineSize : list) {
            count += tangerineSize;
            sizeType++;
            if (count >= k) { // 선택한 귤의 개수가 K 개수보다 크거나 같을경우 현재까지 선택한 귤의 종류가 최소가 됌
                return sizeType;
            }
        }

        return sizeType;
    }
}
