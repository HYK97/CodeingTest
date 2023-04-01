package etc;

import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public String[] solution(String[] history, String[][] option, String keyword) {
        String[] answer = {};
        List<String> data = new ArrayList<>();
        if (option.length == 0 || option[0][1].equals("F")) {
            for (String his : history) {
                if (his.equals(keyword)) {
                    data.add(his);
                }
            }
        } else {
            for (String his : history) {
                String[] splits = his.split(" ");
                for (String split : splits) {
                    if (split.equals(keyword)) {
                        data.add(his);
                        break;
                    }
                }
            }
        }
        System.out.println(data);
        return data.toArray(new String[0]);
    }
}