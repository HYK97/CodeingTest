package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class No1926 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		new No1926().solution();
	}

	@Override
	public void solution() throws IOException {
		String[] split = br.readLine().split(" ");
		int x = Integer.parseInt(split[0]);
		int y = Integer.parseInt(split[1]);
		int[][] board = new int[x][y];
		int[][] check = new int[x][y];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		int imageCount = 0;
		int maxImageSize = 0;
		for (int i = 0; i < x; i++) {
			int[] s = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(check[i], 0);
			board[i] = s;
		}

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (board[i][j] == 0 || check[i][j] == 1) {
					continue;
				}
				imageCount++;
				LinkedList<Pair> queue = new LinkedList<>();
				check[i][j] = 1;
				queue.add(new Pair(i, j));
				int imageSize = 0;
				while (!queue.isEmpty()) {
					imageSize++;
					Pair current = queue.pollFirst();
					for (int k = 0; k < 4; k++) {
						int newX = current.x + dx[k];
						int newY = current.y + dy[k];
						if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
							continue;
						}
						if (check[newX][newY] == 1 || board[newX][newY] == 0) {
							continue;
						}
						check[newX][newY] = 1;
						queue.add(new Pair(newX, newY));
					}
				}
				maxImageSize = Math.max(maxImageSize, imageSize);

			}
		}
		System.out.println(imageCount);
		System.out.println(maxImageSize);
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
