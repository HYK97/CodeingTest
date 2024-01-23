package baekjoon.bfs;

import baekjoon.template.BaekjoonTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class No2583 extends BaekjoonTemplate {


	public static void main(String[] args) throws IOException {
		final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] split = br.readLine().split(" ");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		int k = Integer.parseInt(split[2]);
		int[][] map = new int[m][n];
		boolean[][] check = new boolean[m][n];
		int[] dx = {1, 0, -1, 0};
		int[] dy = {0, 1, 0, -1};


		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], 0);
			Arrays.fill(check[i], false);
		}
		for (int i = 0; i < k; i++) {
			String[] split1 = br.readLine().split(" ");
			Pair leftDown = new Pair(Integer.parseInt(split1[0]), Integer.parseInt(split1[1]));
			Pair rightUp = new Pair(Integer.parseInt(split1[2]), Integer.parseInt(split1[3]));

			for (int j = leftDown.y; j < rightUp.y; j++) {
				for (int l = leftDown.x; l < rightUp.x; l++) {
					map[j][l] = 1;
				}
			}
		}
		int boxCount = 0;
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				Queue<Pair> queue = new LinkedList<>();
				if (map[i][j] != 0 || check[i][j]) {
					continue;
				}
				queue.add(new Pair(i, j));
				check[i][j] = true;
				int countArea = 1;
				while (!queue.isEmpty()) {
					Pair current = queue.poll();
					for (int l = 0; l < 4; l++) {
						int newX = current.x + dx[l];
						int newY = current.y + dy[l];
						if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
							continue;
						}
						if (map[newX][newY] != 0 || check[newX][newY]) {
							continue;
						}
						queue.add(new Pair(newX,newY));
						check[newX][newY]=true;
						countArea++;
					}
				}
				result.add(countArea);
				boxCount++;
			}


		}
		System.out.println(boxCount);
		result.sort(Integer::compareTo);
		for (Integer integer : result) {
			System.out.print(integer+" ");
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
