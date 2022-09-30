package programmers.dfs_bfs;

public class 타겟넘버 {
    int[] numbers;
    int answer = 0;

    int target;

    public static void main(String[] args) {
        타겟넘버 t = new 타겟넘버();
        int solution = t.solution(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println("solution = " + solution);
    }

    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        dfs(0, 0);
        return answer;
    }

    public void dfs(int index, int sum) {
        if (index == numbers.length) {
            if (target == sum) {
                answer++;
            }
            return;
        }
        //순서 +++++ - > ++++- -> +++-+ -> 이런식으로 스택이 구성된다.
        dfs(index + 1, sum + numbers[index]);
        dfs(index + 1, sum - numbers[index]);
    }
}
