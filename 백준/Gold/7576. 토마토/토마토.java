import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int x = Integer.parseInt(split[1]);
		int y = Integer.parseInt(split[0]);
		int[][] map = new int[x][y];
		int[][] check = new int[x][y];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		Queue<Pair> queue = new LinkedList<>();
        
		for (int i = 0; i < x; i++) {
			String[] split1 = br.readLine().split(" ");
			int[] array = Arrays.stream(split1).mapToInt(Integer::parseInt).toArray();
			map[i] = array;
			Arrays.fill(check[i], 0);
		}
        
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (map[i][j] == 1) {
					queue.add(new Pair(i, j));
					check[i][j] = 1;
				}
			}
		}

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
					continue;
				}
				if (map[newX][newY] != 0 || check[newX][newY] != 0) {
					continue;
				}
				queue.add(new Pair(newX, newY));
				check[newX][newY] = check[current.x][current.y] + 1;
			}
		}

		int maxDate = 0;
        
		for (int i = 0; i < check.length; i++) {
			int[] array = check[i];
			for (int j = 0; j < array.length; j++) {
				if (check[i][j] == 0 && map[i][j] == 0) {
					System.out.println(-1);
					return;
				}
				maxDate = Math.max(maxDate, array[j]);
			}
		}
        
		System.out.println(maxDate - 1);
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
