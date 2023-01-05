package programmers.impl;

import java.util.Map;
import java.util.TreeMap;

/**
 * packageName :  programmers.impl
 * fileName : 주차요금계산
 * author :  ddh96
 * date : 2023-01-05 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-05                ddh96             최초 생성
 */
public class 주차요금계산 {

    public static void main(String[] args) {
        주차요금계산 주차요금계산 = new 주차요금계산();
        주차요금계산.solution(new int[] {180, 5000, 10, 600},
            new String[] {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN",
                "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"});
    }

    //시간계산
    private void process(String 시간, String 상태, Receipt receipt) {
        상태확인(시간, 상태, receipt);
        receipt.시간계산();
        if (상태.equals("OUT")) {
            receipt.input = null;
            receipt.output = null;
        }
    }

    private void 상태확인(String 시간, String 상태, Receipt receipt) {
        if (상태.equals("IN")) {
            receipt.setInput(시간);
        } else {
            receipt.setOutput(시간);
        }
    }

    public int[] solution(int[] fees, String[] records) {
        int 기본시간 = fees[0];
        int 기본요금 = fees[1];
        int 단위시간 = fees[2];
        int 단위요금 = fees[3];
        Map<String, Receipt> map = new TreeMap<>(String::compareTo);

        for (String record : records) {
            String[] split = record.split(" ");
            String 시간 = split[0];
            String 차번호 = split[1];
            String 상태 = split[2];

            //차없을때
            if (!map.containsKey(차번호)) {
                Receipt receipt = new Receipt();
                map.put(차번호, receipt);
                process(시간, 상태, receipt);
            }
            //차한번이라도 들어갔을때
            Receipt receipt = map.get(차번호);
            process(시간, 상태, receipt);

        }

        //요금계산
        for (String key : map.keySet()) {
            Receipt receipt = map.get(key);
            if (receipt.input != null) {
                receipt.setOutput("23:59");
                receipt.시간계산();
            }
            receipt.계산(기본시간, 기본요금, 단위시간, 단위요금);
        }

        //출력
        int[] answer = new int[map.size()];
        int index = 0;
        for (String integer : map.keySet()) {
            answer[index] = map.get(integer).charge;
            index++;
        }
        return answer;
    }

    static class Receipt {
        int charge;

        Integer input;
        Integer output;

        Integer time = 0;

        public Receipt() {

        }

        //시간계산
        private static int timeCalculation(String output) {
            String[] split = output.split(":");
            int hour = Integer.parseInt(split[0]);
            int minute = Integer.parseInt(split[1]);
            return (hour * 60) + minute;
        }

        public void 시간계산() {
            if (input == null || output == null) {
                return;
            }
            this.time += output - input;
        }

        public void 계산(int 기본시간, int 기본요금, int 단위시간, int 단위요금) {

            if (time <= 기본시간) {
                charge = 기본요금;
                return;
            }
            int ceil = (int)Math.ceil((time - 기본시간) / (double)단위시간);
            int 계산값 = 기본요금 + (ceil * 단위요금);
            charge = 계산값;

        }

        public void setInput(String input) {
            this.input = timeCalculation(input);
        }

        public void setOutput(String output) {
            this.output = timeCalculation(output);
        }

    }

}
