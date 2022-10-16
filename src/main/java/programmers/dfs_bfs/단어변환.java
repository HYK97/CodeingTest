package programmers.dfs_bfs;

public class 단어변환 {
    static String[] words = new String[]{"hot", "dot", "dog", "lot", "log", "cog"};
    static boolean[] visited = new boolean[words.length];
    static int result = 9999; //9999면 0

    public static void main(String[] args) throws InterruptedException {
        dfs("cog", "hit", 0);
        System.out.println("result = " + result);
    }

    static void dfs(String target, String begin, int dept) throws InterruptedException {
        if (begin.equals(target) || dept >= words.length) {
            if (begin.equals(target) && result > dept) {
                result = dept; // 제일작은값 저장
                return;
            }
        }

        for (int i = 0; i < words.length; i++) {
            if (check(begin, words[i]) && !visited[i]) {
                visited[i] = true;
                dfs(target, words[i], ++dept);

                //백트래킹 실행하지 않았던 조건으로 돌아가기
                visited[i] = false;
                --dept;
            }

        }
    }


    static boolean check(String begin, String word) { //같은 자리에 다른 알파벳인경우를 체크하는 메서드
        String[] split = begin.split("");
        String[] split1 = word.split("");
        int count = 0;
        for (int i = 0; i < split1.length; i++) {
            if (!split[i].equals(split1[i])) {
                count++;
            }
        }
        return count == 1;
    }

}
