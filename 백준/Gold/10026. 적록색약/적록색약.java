import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[][] map = new String[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}
		
		int nonColorBlindness = nonColorBlindness(map, newCheckArray(N));
		int colorBlindness = colorBlindness(map, newCheckArray(N));
		System.out.println(nonColorBlindness + " " + colorBlindness);

	}

	private static boolean[][] newCheckArray(int N) {
		boolean[][] check = new boolean[N][N];
		for (boolean[] booleans : check) {
			Arrays.fill(booleans, false);
		}
		return check;
	}

	private static int nonColorBlindness(String[][] map, boolean[][] check) {
		Queue<Pair> queue = new LinkedList<>();
		int N = map.length;
		int count = 0;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (check[x][y]) {
					continue;
				}
				queue.add(new Pair(x, y));
				check[x][y] = true;
				while (!queue.isEmpty()) {
					Pair current = queue.poll();
					for (int k = 0; k < 4; k++) {
						int newX = current.x + dx[k];
						int newY = current.y + dy[k];
						if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
							continue;
						}
						if (!map[current.x][current.y].equals(map[newX][newY]) || check[newX][newY]) {
							continue;
						}

						queue.add(new Pair(newX, newY));
						check[newX][newY] = true;
					}
				}
				count++;
			}
		}
		return count;
	}

	private static int colorBlindness(String[][] map, boolean[][] check) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j].equals("G")) {
					map[i][j] = "R";
				}
			}
		}
		Queue<Pair> queue = new LinkedList<>();
		int N = map.length;
		int count = 0;
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				if (check[x][y]) {
					continue;
				}
				queue.add(new Pair(x, y));
				check[x][y] = true;
				while (!queue.isEmpty()) {
					Pair current = queue.poll();
					for (int k = 0; k < 4; k++) {
						int newX = current.x + dx[k];
						int newY = current.y + dy[k];
						if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
							continue;
						}
						if (!map[current.x][current.y].equals(map[newX][newY]) || check[newX][newY]) {
							continue;
						}
						queue.add(new Pair(newX, newY));
						check[newX][newY] = true;
					}
				}
				count++;
			}
		}
		return count;
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


