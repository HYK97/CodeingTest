import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int z = Integer.parseInt(split[2]);
		int[][][] map = new int[z][y][x];
		int[][][] check = new int[z][y][x];
		int[] dx = {1, 0, -1, 0, 0, 0};
		int[] dy = {0, 1, 0, -1, 0, 0};
		int[] dz = {0, 0, 0, 0, 1, -1};
		Queue<Pair> queue = new LinkedList<>();
		int zeroCount = 0;
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				String[] split1 = br.readLine().split(" ");
				for (int k = 0; k < x; k++) {
					map[i][j][k] = Integer.parseInt(split1[k]);
					check[i][j][k] = -1;
					if (map[i][j][k] == 1) {
						queue.add(new Pair(k, j, i));
						check[i][j][k] = 0;
					}
					if (map[i][j][k] == 0) {
						zeroCount++;
					}
				}
			}
		}
		if (zeroCount == 0) {
			System.out.println(0);
			return;
		}

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			for (int i = 0; i < 6; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				int newZ = current.z + dz[i];
				if (newX < 0 || newX >= x || newY < 0 || newY >= y || newZ < 0 || newZ >= z) {
					continue;
				}
				if (map[newZ][newY][newX] == 1 || map[newZ][newY][newX] == -1 || check[newZ][newY][newX] != -1) {
					continue;
				}
				queue.add(new Pair(newX, newY, newZ));
				check[newZ][newY][newX] = check[current.z][current.y][current.x] + 1;
			}
		}

		int max = -1;
		for (int i = 0; i < z; i++) {
			for (int j = 0; j < y; j++) {
				for (int k = 0; k < x; k++) {
					if (check[i][j][k] == -1 && map[i][j][k] == 0) {
						System.out.println(-1);
						return;
					}
					max = Math.max(max, check[i][j][k]);
				}
			}
		}
		System.out.println(max);


	}

	static class Pair {
		int x;
		int y;
		int z;

		public Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
}

