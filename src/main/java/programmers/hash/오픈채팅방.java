package programmers.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * packageName :  programmers.hash
 * fileName : 오픈채팅방
 * author :  ddh96
 * date : 2023-04-12 
 * description :https://school.programmers.co.kr/learn/courses/30/lessons/42888
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-04-12                ddh96             최초 생성
 */
public class 오픈채팅방 {
    public String[] solution(String[] record) {
        String[] answer = {};
        HashMap<String, String> idMapper = new HashMap<>();
        List<Record> inOutRecord = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (String rd : record) {
            String[] splitData = rd.split(" ");
            String status = splitData[0];
            String userId = splitData[1];
            if (status.equals("Enter") || status.equals("Leave")) {
                inOutRecord.add(new Record(userId, status));
            }
            if (status.equals("Enter") || status.equals("Change")) {
                String nickname = splitData[2];
                idMapper.put(userId, nickname);
            }

        }
        for (Record rd : inOutRecord) {
            if (rd.status.equals("Enter")) {
                result.add(idMapper.get(rd.userId) + "님이 들어왔습니다.");
            } else {
                result.add(idMapper.get(rd.userId) + "님이 나갔습니다.");
            }
        }

        return result.stream().map(String::valueOf).toArray(String[]::new);
    }

    static class Record {
        String userId;
        String status;

        Record(String userId, String status) {
            this.userId = userId;
            this.status = status;
        }
    }
}
