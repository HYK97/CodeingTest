package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class No5427 extends BaekjoonTemplate {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int quizCount = Integer.parseInt(br.readLine());
		for (int i = 0; i < quizCount; i++) {
			String[] split = br.readLine().split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			String[][] map = new String[y][x];
			int[][] fireMap = new int[y][x];
			int[][] sangMap = new int[y][x];
			int[] dx = {1, 0, -1, 0};
			int[] dy = {0, 1, 0, -1};

			Queue<Pair> fireQueue = new LinkedList<>();
			Queue<Pair> sangQueue = new LinkedList<>();

			for (int j = 0; j < y; j++) {
				String[] line = br.readLine().split("");
				for (int k = 0; k < x; k++) {
					map[j][k] = line[k];

					if (map[j][k].equals("@")) {
						sangQueue.add(new Pair(k, j));
						sangMap[j][k] = 0;
						fireMap[j][k] = -1;
						continue;
					}

					if (map[j][k].equals("*")) {
						fireQueue.add(new Pair(k, j));
						fireMap[j][k] = 0;
						sangMap[j][k] = -1;
						continue;
					}

					sangMap[j][k] = -1;
					fireMap[j][k] = -1;

				}
			}


			while (!fireQueue.isEmpty()) {
				Pair current = fireQueue.poll();
				for (int j = 0; j < 4; j++) {
					int newX = current.x + dx[j];
					int newY = current.y + dy[j];
					if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
						continue;
					}
					if (fireMap[newY][newX] != -1 || map[newY][newX].equals("#")) {
						continue;
					}
					fireQueue.add(new Pair(newX, newY));
					fireMap[newY][newX] = fireMap[current.y][current.x] + 1;
				}
			}


			boolean flag = true;
			while (!sangQueue.isEmpty()) {
				if (!flag) {
					break;
				}
				Pair current = sangQueue.poll();
				for (int j = 0; j < 4; j++) {
					int newX = current.x + dx[j];
					int newY = current.y + dy[j];
					if (newX < 0 || newX >= x || newY < 0 || newY >= y) {
						System.out.println(sangMap[current.y][current.x] + 1);
						flag = false;
						break;
					}
					if (sangMap[newY][newX] != -1 || map[newY][newX].equals("#")) {
						continue;
					}
					if (fireMap[newY][newX] != -1 && fireMap[newY][newX] <= sangMap[current.y][current.x] + 1) {
						continue;
					}
					sangQueue.add(new Pair(newX, newY));
					sangMap[newY][newX] = sangMap[current.y][current.x] + 1;
				}
			}
			if (flag) {
				System.out.println("IMPOSSIBLE");
			}
		}
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
/*
1
4 3
####
#*.@
####*/
