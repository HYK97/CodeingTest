package algorithm.sort;

import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class VectorAndPairSort {

    /**
     * vector 와 직접만든 pair를 이용한 sort 작업 ->comparator 는정렬 조건을 지정하는 functionalInterface이다.
     */
    public static void main(String[] args) {
        Comparator<Pair> comparator = new Comparator<Pair>() {
            public int compare(Pair p1, Pair p2) {
                if (p1.getSecond() <= p2.getSecond()) {
                    return -1;
                } else {
                    return 1;
                }
            }
        };

        Vector<Pair> vector = new Vector<Pair>();
        vector.add(new Pair("김현용", 99));
        vector.add(new Pair("김진우", 100));
        vector.add(new Pair("우상훈", 44));

        Collections.sort(vector, comparator);
        for (Pair p : vector) {
            System.out.println("p.toString() = " + p.toString());

        }

    }
}

class Pair {
    String first;
    Integer second;

    public Pair(String first, Integer second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first='" + first + '\'' +
                ", second=" + second +
                '}';
    }

    public String getFirst() {
        return first;
    }

    public Integer getSecond() {
        return second;
    }
}
