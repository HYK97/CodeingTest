package algorithm.sort;

public class Recursion {


    public static void main(String[] args) {
        int recursion = recursion(5);
        System.out.println("recursion = " + recursion);
    }


    public static int recursion(int index) {

        if (index < 3) {
            return 1;

        } else {     //이개 1번함수일경우             2번함수일 경우             실행순서 = 11112222 방식
            int i = recursion(index - 1) + recursion(index - 2);
            //이부분이 먼저 실행되면서       앞의 함수에 이어서
            //스택에 계속 쌓이게 된다.       마찬가지로 호출된다.
            //마지막 함수가 호출되고
            //다시 자신이 호출된곳으로 호출
            //그다음  -> 함수가실행된다

            return i;

        }

    }

}
