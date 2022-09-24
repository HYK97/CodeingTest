package datastructure.array;

import java.util.StringJoiner;

public class 다항식 {

    static int resultCount = 0;

    public static void main(String[] args) {
        Temrs[] data = new Temrs[]{new Temrs(8, 3), new Temrs(7, 2), new Temrs(5, 3), new Temrs(10, 1)};
        Temrs[] result = add(0, 1, 2, 3, data);
        StringJoiner joiner = new StringJoiner(" + ");
        for (int i = 0; i <= resultCount; i++) {
            joiner.add(result[i].coef + "X" + result[i].expon);
        }
        System.out.println(joiner);


    }

    private static Temrs[] add(int s1, int e1, int s2, int e2, Temrs[] data) {
        Temrs[] result = new Temrs[data.length];

        while (s1 <= e1 && s2 <= e2) {
            int compare = data[s1].compareTo(data[s2]);
            if (compare > 0) {
                result[resultCount] = new Temrs(data[s1]);
                s1++;
            } else if (compare < 0) {
                result[resultCount] = new Temrs(data[s2]);
                s2++;
            } else {
                result[resultCount] = new Temrs(data[s1].coef + data[s2].coef, data[s1].expon);
                s1++;
                s2++;
            }
            resultCount++;
        }
        for (int i = s1; i <= e1; i++) {
            result[resultCount] = new Temrs(data[i]);
        }
        for (int i = s2; i <= e2; i++) {
            result[resultCount] = new Temrs(data[i]);
        }

        return result;
    }

    static class Temrs implements Comparable {
        int coef; //계수
        int expon; //지수

        public Temrs(int coef, int expon) {
            this.coef = coef;
            this.expon = expon;
        }

        public Temrs(Temrs newTemr) {
            this.coef = newTemr.coef;
            this.expon = newTemr.expon;
        }


        @Override
        public int compareTo(Object o) {
            Temrs d = (Temrs) o;
            //10  5
            return this.expon - d.expon;
        }
    }
}
