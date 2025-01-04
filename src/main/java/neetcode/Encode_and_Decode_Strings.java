package neetcode;

import java.util.ArrayList;
import java.util.List;

public class Encode_and_Decode_Strings {
    public String encode(List<String> strs) {
        String encode = "";
        for (String str : strs) {
            encode += str.length() + "?" + str;
        }
        return encode;
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        String[] split = str.split("");
        if (split.length == 0 || split[0].equals("")) {
            return result;
        }
        int i = 0;
        while (i < split.length) {
            String s = "";
            while (split[i].matches("\\d+")) {
                s += split[i];
                i++;
            }
            if (split[i] != null && split[i].equals("?")) {
                int startIndex = i + 1; // 슬래시 다음 인덱스로 이동
                String orignalString = "";
                while (startIndex <= i + Integer.parseInt(s)) {
                    orignalString += split[startIndex];
                    startIndex++;
                }
                result.add(orignalString);
                i = startIndex; // 인덱스 동기화
            }
        }
        return result;
    }
}
