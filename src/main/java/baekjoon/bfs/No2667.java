package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class No2667 extends BaekjoonTemplate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] check = new boolean[N][N];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};
		for (int i = 0; i < N; i++) {
			map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
			Arrays.fill(check[i], false);
		}
		int complexCount = 0;
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check[i][j] || map[i][j] == 0) {
					continue;
				}
				Queue<Pair> queue = new LinkedList<>();
				queue.add(new Pair(i, j));
				check[i][j] = true;
				int houseCount = 1;
				while (!queue.isEmpty()) {
					Pair current = queue.poll();
					for (int k = 0; k < 4; k++) {
						int newX = current.x + dx[k];
						int newY = current.y + dy[k];
						if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
							continue;
						}
						if (check[newX][newY] || map[newX][newY] == 0) {
							continue;
						}
						queue.add(new Pair(newX, newY));
						check[newX][newY] = true;
						houseCount++;
					}
				}
				complexCount++;
				result.add(houseCount);
			}
		}
		System.out.println(complexCount);
		result.stream().sorted().forEach(System.out::println);
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
