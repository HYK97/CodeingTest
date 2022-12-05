package datastructure.array.quiz;

/**
 * packageName :  datastructure.array.quiz
 * fileName : Peek
 * author :  ddh96
 * date : 2022-12-05 
 * description : peek 값출력하기
 * peek 값은 배열 양쪽보다 큰값을 말한다
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-05                ddh96             최초 생성
 */
public class Peek {
    public static void main(String[] args) {
        int[] data = {3, 1, 2, 6, 2, 2, 5, 1, 9, 10, 1, 11};
        for (int i = 0; i < data.length; i++) {

            if (i == 0) {
                if (data[i] > data[i + 1]) {
                    System.out.print(data[i] + " ");
                }
            }
            if (i == data.length - 1) {
                if (data[i] > data[i - 1]) {
                    System.out.println(data[i]);
                }
            }
            if (i > 0 && i < data.length - 1 && data[i] > data[i + 1] && data[i] > data[i - 1]) {
                System.out.print(data[i] + " ");
            }
        }

    }
}
