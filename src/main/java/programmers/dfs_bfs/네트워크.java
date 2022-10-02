package programmers.dfs_bfs;

public class 네트워크 {
    static int[][] data = new int[][]{
            //0  1   2
            /*0*/  {1, 1, 0},
            /*1*/  {1, 1, 0},
            /*2*/  {0, 0, 1}};
    static boolean[] check;

    public static void main(String[] args) {

        int solution = solution(3);
        System.out.println("solution = " + solution);
    }

    public static int solution(int n) {
        check = new boolean[n];
        int count = 0;
        for (int i = 0; i < data.length; i++) {
            if (!check[i]) {
                count++;
                dfs(i);
            }
        }
        return count;
    }


    public static void dfs(int x) {
        //한줄 전체 돌면서 자신한테 붙은 노드들 모두 돌기
        for (int i = 0; i < data[x].length; i++) {
            if (data[x][i] == 1 && !check[i]) {
                check[i] = true;
                dfs(i);
            }
        }
    }
}
