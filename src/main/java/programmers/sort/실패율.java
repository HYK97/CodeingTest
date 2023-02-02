package programmers.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * packageName :  programmers.sort
 * fileName : 실패율
 * author :  ddh96
 * date : 2023-02-02 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-02-02                ddh96             최초 생성
 */
public class 실패율 {
    public int[] solution(int N, int[] stages) {

        List<Data> data = new ArrayList<>();
        for (int currentStage = 1; currentStage <= N; currentStage++) {
            int 도달함 = 0;
            int noClear = 0;
            for (int stage : stages) {
                if (currentStage <= stage) {
                    도달함++;
                }
                if (currentStage == stage) {
                    noClear++;
                }
            }
            data.add(new Data(currentStage, noClear, 도달함));
        }
        for (Data datum : data) {
            System.out.println("datum = " + datum);
        }
        return data.stream().sorted().mapToInt(i -> i.stage).toArray();

    }

    static class Data implements Comparable<Data> {
        double 실패율;
        int stage;
        int noClear;
        int 도달함;

        public Data(int stage, int noClear, int 도달함) {
            if (noClear == 0 && 도달함 != 0) {
                this.실패율 = 0;
            } else {
                this.실패율 = (double)noClear / 도달함;
            }
            this.stage = stage;
            this.noClear = noClear;
            this.도달함 = 도달함;
        }

        @Override
        public String toString() {
            return "Data{" +
                "실패율=" + 실패율 +
                ", stage=" + stage +
                ", noClear=" + noClear +
                ", 도달함=" + 도달함 +
                '}';
        }

        @Override
        public int compareTo(Data o) {
            if (this.실패율 == o.실패율) {
                return this.stage - o.stage;
            } else {
                return (this.실패율 > o.실패율) ? -1 : 1;
            }
        }
    }
}
