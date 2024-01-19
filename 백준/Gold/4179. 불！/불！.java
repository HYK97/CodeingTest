import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int x = Integer.parseInt(inputs[0]);
        int y = Integer.parseInt(inputs[1]);
        String[][] map = new String[x][y];
        Integer[][] jihunMap = new Integer[x][y];
        Integer[][] fireMap = new Integer[x][y];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Pair> fireQueue = new LinkedList<>();
        Queue<Pair> jihunQueue = new LinkedList<>();

        for (int i = 0; i < x; i++) {
            String[] split = br.readLine().split("");
            Arrays.fill(jihunMap[i], -1);
            Arrays.fill(fireMap[i], -1);
            for (int j = 0; j < y; j++) {
                map[i][j] = split[j];
                if (map[i][j].equals("J")) {
                    jihunQueue.add(new Pair(i, j));
                    jihunMap[i][j]++;
                    continue;
                }
                if (map[i][j].equals("F")) {
                    fireQueue.add(new Pair(i, j));
                    fireMap[i][j]++;
                }

            }
        }

        while (!fireQueue.isEmpty()) {
            Pair current = fireQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
                    continue;
                }
                if (fireMap[newX][newY] != -1 || map[newX][newY].equals("#")) {
                    continue;
                }
                fireQueue.add(new Pair(newX, newY));
                fireMap[newX][newY] = fireMap[current.x][current.y] + 1;
            }
        }

        while (!jihunQueue.isEmpty()) {
            Pair current = jihunQueue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = current.x + dx[i];
                int newY = current.y + dy[i];
                // 끝점에 도달하면 이미 탈출한것으로 현재 좌표의 값을 return
                if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
                    System.out.println(jihunMap[current.x][current.y] + 1); // 다음 좌표를 미리 계산해서 출력
                    return;
                }
                if (jihunMap[newX][newY] >= 0 || map[newX][newY].equals("#")) {
                    continue;
                }

                if (fireMap[current.x][current.y] >= 0 //현재 좌표에 불이 번진적이 없는 경우
                    && fireMap[newX][newY] <= jihunMap[current.x][current.y] + 1) { //다음 좌표에 불이 붙을 시간과 지훈이 다음 좌표에 도착하는 시간과 크거나 같으면( +1 하는이유는 다음좌표랑 비교하려고)
                    continue;
                }
                jihunQueue.add(new Pair(newX, newY));
                jihunMap[newX][newY] = jihunMap[current.x][current.y] + 1;
            }
        }

        System.out.println("IMPOSSIBLE");

    }

    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}