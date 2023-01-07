package programmers.ex_search;

/**
 * packageName :  programmers.dfs_bfs
 * fileName : 이모티콘할인행사
 * author :  ddh96
 * date : 2023-01-07 
 * description :
 *
 *  모든 이모티콘의 할인 퍼센트에 대한
 *   user의 총개수와
 * ===========================================================
 * DATE                 AUTHOR                NOTE
 * -----------------------------------------------------------
 * 2023-01-07                ddh96             최초 생성
 */
public class 이모티콘할인행사 {
    static int[][] userss;
    static int[] emoticonss;
    static int value1 = -1;
    static int value2 = -1;

    private static void process(int[] discount) {

        int 총구매비용 = 0;
        int 플러스가입사람수 = 0;
        for (int[] user : userss) {
            int 할인율 = user[0];
            int 구매비용마지노선 = user[1];
            int 구매비용 = 0;
            for (int i = 0; i < discount.length; i++) {
                if (할인율 <= discount[i]) {
                    구매비용 += (emoticonss[i] - (emoticonss[i] * (discount[i] * 0.01)));
                }
            }
            if (구매비용마지노선 <= 구매비용) {
                플러스가입사람수++;
            } else {
                총구매비용 += 구매비용;
            }
        }
        if (value1 == -1) {
            update(총구매비용, 플러스가입사람수);
        } else {
            if (value1 < 플러스가입사람수) {
                update(총구매비용, 플러스가입사람수);
            } else if (value1 == 플러스가입사람수) {
                if (value2 < 총구매비용) {
                    update(총구매비용, 플러스가입사람수);
                }
            }
        }
    }

    private static void update(int 총구매비용, int 플러스가입사람수) {
        value1 = 플러스가입사람수;
        value2 = 총구매비용;
    }

    public static void main(String[] args) {
        이모티콘할인행사 a = new 이모티콘할인행사();
        a.solution(new int[][] {{40, 10000}, {25, 10000}}, new int[] {7000, 9000});
    }

    public int[] solution(int[][] users, int[] emoticons) {
        userss = users;
        emoticonss = emoticons;
        int[] discount = new int[emoticons.length];
        dfs(0, discount);
        return new int[] {value1, value2};
    }

    public void dfs(int depth, int[] discount) {
        if (depth == discount.length) {
            process(discount);
            return;
        }
        int[] arr = {10, 20, 30, 40};
        for (int j : arr) {
            discount[depth] = j;
            dfs(depth + 1, discount);
        }
    }

}
