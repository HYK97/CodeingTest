package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No2468 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int MAX = 0;
		int[][] originalMap = new int[N][N];
		int[] dx = {-1, 0, 1, 0};
		int[] dy = {0, -1, 0, 1};
		for (int i = 0; i < N; i++) {
			originalMap[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}
		for (int i = 1; i <= 100; i++) {
			int[][] newMap = new int[N][N];
			boolean[][] check = new boolean[N][N];
			Queue<Pair> queue = new LinkedList<>();


			for (int j = 0; j < originalMap.length; j++) {
				int[] ints = originalMap[j];
				Arrays.fill(check[j], false);
				for (int k = 0; k < ints.length; k++) {
					int anInt = ints[k];
					if (anInt > i) {
						newMap[j][k] = 1;
					} else {
						newMap[j][k] = 0;
					}
				}
			}
			int numberOfAreas = 0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (check[x][y] || newMap[x][y] == 0) {
						continue;
					}
					queue.add(new Pair(x, y));
					check[x][y] = true;
					while (!queue.isEmpty()) {
						Pair current = queue.poll();
						for (int j = 0; j < 4; j++) {
							int newX = current.x + dx[j];
							int newY = current.y + dy[j];
							if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
								continue;
							}
							if (check[newX][newY] || newMap[newX][newY] == 0) {
								continue;
							}
							queue.add(new Pair(newX, newY));
							check[newX][newY] = true;
						}
					}
					numberOfAreas++;
				}
			}

			MAX = Math.max(numberOfAreas, MAX);
		}
		System.out.println(MAX);
	}

	@Override
	public void solution() throws IOException {

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
