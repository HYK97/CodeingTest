import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int quizCount = Integer.parseInt(br.readLine());
		int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
		int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};
		for (int i = 0; i < quizCount; i++) {
			int N = Integer.parseInt(br.readLine());
			int[][] count = new int[N][N];
			Queue<Pair> queue = new LinkedList<>();
			String[] split = br.readLine().split(" ");
			String[] target = br.readLine().split(" ");
			int targetX = Integer.parseInt(target[0]);
			int targetY = Integer.parseInt(target[1]);
			int startX = Integer.parseInt(split[0]);
			int startY = Integer.parseInt(split[1]);

			for (int[] ints : count) {
				Arrays.fill(ints, 0);
			}

			queue.add(new Pair(startX, startY));
			count[startX][startY] = 1;
			while (!queue.isEmpty()) {
				Pair current = queue.poll();
				for (int j = 0; j < 8; j++) {
					int newX = current.x + dx[j];
					int newY = current.y + dy[j];
					if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
						continue;
					}
					if (count[newX][newY] != 0) {
						continue;
					}
					queue.add(new Pair(newX, newY));
					count[newX][newY] = count[current.x][current.y] + 1;
				}
			}
			System.out.println(count[targetX][targetY] - 1);
		}
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
