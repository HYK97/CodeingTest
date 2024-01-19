package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No1012 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		new No1012().solution();
	}

	@Override
	public void solution() throws IOException {
		int testCase = Integer.parseInt(br.readLine());
		for (int i = 0; i < testCase; i++) {
			String[] input = br.readLine().split(" ");
			int x = Integer.parseInt(input[0]);
			int y = Integer.parseInt(input[1]);
			int cabbageCount = Integer.parseInt(input[2]);
			int[][] map = new int[x][y];
			boolean[][] check = new boolean[x][y];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};
			int count = 0;
			for (int j = 0; j < x; j++) {
				Arrays.fill(map[j], 0);
				Arrays.fill(check[j], false);
			}

			for (int j = 0; j < cabbageCount; j++) {
				String[] pathInput = br.readLine().split(" ");
				map[Integer.parseInt(pathInput[0])][Integer.parseInt(pathInput[1])] = 1;
			}


			for (int X = 0; X < x; X++) {
				for (int Y = 0; Y < y; Y++) {
					if (check[X][Y] || map[X][Y] == 0) {
						continue;
					}
					Queue<Pair> queue = new LinkedList<>();
					queue.add(new Pair(X, Y));
					check[X][Y] = true;
					while (!queue.isEmpty()) {
						Pair current = queue.poll();
						for (int j = 0; j < 4; j++) {
							int newX = current.x + dx[j];
							int newY = current.y + dy[j];
							if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
								continue;
							}
							if (check[newX][newY] || map[newX][newY] == 0) {
								continue;
							}
							queue.add(new Pair(newX, newY));
							check[newX][newY] = true;
						}
					}
					count++;
				}
			}
			System.out.println(count);
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
