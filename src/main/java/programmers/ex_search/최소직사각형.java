package programmers.ex_search;

/**
 * packageName :  programmers.ex_search
 * fileName : 최소직사각형
 * author :  ddh96
 * date : 2022-12-12 
 * description :
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2022-12-12                ddh96             최초 생성
 */
public class 최소직사각형 {
    public static void main(String[] args) {

    }

    public int solution(int[][] sizes) {
        int answer = 0;
        // 한개씩 바꿔서 전체 탐색을 해보면된다
        int resultWidth = Integer.MIN_VALUE;
        int resultHeight = Integer.MIN_VALUE;
        for (int j = 0; j < sizes.length; j++) {
            if (sizes[j][0] < sizes[j][1]) {
                swap(sizes, j);
            }
        }
        for (int[] size : sizes) {
            resultWidth = Math.max(size[0], resultWidth);
            resultHeight = Math.max(size[1], resultHeight);
        }

        return resultWidth * resultHeight;
    }

    public void swap(int[][] arr, int j) {
        int temp;
        temp = arr[j][0];
        arr[j][0] = arr[j][1];
        arr[j][1] = temp;
    }
}
