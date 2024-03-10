package programmers.pccp;

import java.util.*;


class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int solution1 = solution.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
		System.out.println("solution1 = " + solution1);
	}

	static int dx[] = {1, 0, -1, 0};
	static int dy[] = {0, 1, 0, -1};
	static int[] oil;
	static boolean[][] check;

	public int solution(int[][] land) {
		oil = new int[land[0].length];

		Arrays.fill(oil, 0);

		int y = land.length;
		int x = land[0].length;
		check = new boolean[y][x];

		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (land[j][i] == 0 || check[j][i]) {
					continue;
				}
				bfs(land, i, j);
			}
		}

		return Arrays.stream(oil).max().getAsInt();
	}

	private static void bfs(int[][] land, int x, int y) {

		Set<Integer> area = new HashSet<>();
		Queue<Pair> queue = new LinkedList<>();
		queue.add(new Pair(x, y));
		check[y][x] = true;
		area.add(x);
		int count = 1;

		while (!queue.isEmpty()) {
			Pair current = queue.poll();
			for (int i = 0; i < 4; i++) {
				int newX = current.x + dx[i];
				int newY = current.y + dy[i];
				if (newX < 0 || newY < 0 || newX >= land[0].length || newY >= land.length) {
					continue;
				}
				if (check[newY][newX] || land[newY][newX] == 0) {
					continue;
				}
				area.add(newX);
				count++;
				queue.add(new Pair(newX, newY));
				check[newY][newX] = true;
			}
		}
		for (Integer i : area) {
			oil[i] += count;
		}

	}

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}


