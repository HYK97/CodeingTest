package baekjoon;

public class No4673 {
    public static void main(String[] args) {
        System.out.println("1");

        int[] data = new int[5];

        for (int i = 0; i < 10000; i++) {
            String sdata = String.valueOf(data);
            for (int j = 0; j < sdata.length(); j++) {
                int result = j;
                result += sdata.charAt(i) - '0';
            }
        }


        sum(1);
    }

    public static void sum(int data) {
        System.out.println(data);
        String sdata = String.valueOf(data);
        int[] arrayData = new int[5];
        int result = data;
        for (int i = 0; i < sdata.length(); i++) {
            result += sdata.charAt(i) - '0';
        }
        if (result < 10000) {
            sum(result);
        }
    }
}
